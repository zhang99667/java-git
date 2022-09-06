package view;

import domain.House;
import service.HouseService;
import utils.Utility;
/*
    1. 显示界面
    2. 接收用户的输入
    3. 调用 HouseService 完成对房屋信息的各种操作
*/


public class HouseView {
    private boolean loop = true; // 控制显示菜单循环
    private final HouseService houseService = new HouseService(10);

    // 主菜单界面
    public void mainMenu() {
        while (loop) {
            System.out.println("-------------------房屋出租系统-------------------");
            System.out.println("1 新 增 房 源");
            System.out.println("2 查 找 房 源");
            System.out.println("3 删 除 房 源");
            System.out.println("4 修 改 房 屋 信 息");
            System.out.println("5 房 屋 列 表");
            System.out.println("Q 退 出");
            System.out.print("请输入你的选择（1-5）：");
            // 接收用户选择
            char key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case 'q':
                case 'Q':
                    if (Utility.readConfirmSelection())
                        loop = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }


    }

    // 新增房源
    public void addHouse() {
        System.out.println("==========添加房屋==========");
        System.out.print("NAME:");
        String name = Utility.readChar(8);

        System.out.print("TEL:");
        String tel = Utility.readChar(11);

        System.out.print("ADDRESS:");
        String address = Utility.readChar(16);

        System.out.print("RENT:");
        double rent = Utility.readDouble();

        System.out.print("STATE:");
        String state = Utility.readChar(3);

        if (!houseService.add(new House(name, tel, address, rent, state)))
            System.out.println("添加失败！");
        else
            System.out.println("添加成功");
    }


    // 房屋列表
    public void listHouses() {
        System.out.println("==========房屋列表==========");
        System.out.println("ID \t\tNAME \t\tTEL \t\t\tADDRESS \t\t\t\tRENT \t\tSTATE");
        House[] houses = houseService.list();
        for (House house : houses) {
            // 避免空指针
            if (house == null)
                break;
            System.out.println(house);
        }
        System.out.println("============================");
        System.out.println();
    }


    // 删除房源
    public void deleteHouse() {
        System.out.println("==========删除房源==========");
        int delID = Utility.readHouseID(); // 读取输入 ID
        // 选择 -1 ，返回首页
        if (delID == -1)
            return;
        else {
            // 检查 ID 对应房源信息是否存在
            if (houseService.findHouse_ID(delID) == null) {
                System.out.println("当前ID不存在");
                return;
            }
            // 打印房源信息
            System.out.println(houseService.findHouse_ID(delID));
            // 确认删除，调用 delete 函数
            if (Utility.readConfirmSelection()) {
                if (houseService.delete(delID)) // 调用 delete 函数
                    System.out.println("==========删除成功==========");
                else
                    System.out.println("==========删除失败，ID不存在或列表为空==========");
            } else return;
        }
    }


    // 查找房源
    public void findHouse() {
        System.out.println("==========查找房源==========");
        int findID = Utility.readHouseID(); // 读取输入 ID
        House house = houseService.findHouse_ID(findID); // 接收返回的 House 对象
        if (house == null) {
            System.out.println("房屋ID不存在！");
            return;
        } else {
            // 打印相关房屋ID的信息
            System.out.println("ID \t\tNAME \t\tTEL \t\t\tADDRESS \t\t\t\tRENT \t\tSTATE");
            System.out.println(house); // 自动调用 House 的 toString 方法
        }
    }

    // 修改房源
    public void updateHouse() {
        System.out.println("==========修改房源==========");
        int updateID = Utility.readHouseID(); // 读取输入 ID
        // 输入 -1 返回至菜单
        if (updateID == -1)
            return;
        else {
            // 检查 ID 对应房源信息下标
            int index = houseService.getHouseIndex(updateID);
            if (index == -1) {
                System.out.println("房屋ID不存在！");
                return;
            } else {
                House house = houseService.findHouse_ID(updateID); // 接收返回的 House 对象
                System.out.printf("NAME(%s):", house.getName());
                String name_str = Utility.readString(8, house.getName());
                System.out.println();

                System.out.printf("TEL(%s):", house.getPhone());
                String tel_str = Utility.readString(11, house.getPhone());
                System.out.println();

                System.out.printf("ADDRESS(%s):", house.getAddress());
                String address_str = Utility.readString(18, house.getAddress());
                System.out.println();

                System.out.printf("RENT(%s):", house.getRent());
                double rent_str = Utility.readDouble();
                System.out.println();

                System.out.printf("STATE(%s):", house.getState());
                String state_str = Utility.readString(3, house.getState());
                System.out.println();

                House newHouse = new House(name_str, tel_str, address_str, rent_str, state_str);
                if (!houseService.update(updateID, newHouse))
                    System.out.println("==========修改失败==========");
                else
                    System.out.println("==========修改成功==========");
            }
        }
    }
}

