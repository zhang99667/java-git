package service;

import domain.House;

public class HouseService {
    // 声明 houseList 用来保存 House 对象
    private House[] houseList;
    // 记录当前房屋数量
    private int houseNum = 0;
    // 记录房屋ID
    private int idCounter = 0;

    // 带数组长度的构造方法
    public HouseService(int size) {
        houseList = new House[size]; // 创建一个 size 大小的对象
    }


    /*
        返回全部房屋信息
        返回类型： House 对象的数组
    */
    public House[] list() {
        return houseList;
    }

    /*
     * 添加房屋信息
     * 返回类型： boolean
     *  */
    public boolean add(House newHouse) {
        // 判断数组是否已满，如果已满则扩容
        if (houseNum == houseList.length) {
            // 数组扩容
            House[] newHousesList = new House[houseList.length + 10];
            // 将原数组元素复制进新数组
            System.arraycopy(houseList, 0, newHousesList, 0, houseList.length);
            houseList = newHousesList; // 替换引用
        }
        // 将newHouse添加进houseList并更新 houseNum；
        houseList[houseNum++] = newHouse;
        // ID自增
        newHouse.setId(++idCounter);
        return true;
    }


    /*
     * 删除房源信息
     * 返回类型 boolean
     *  */
    public boolean delete(int delID) {
        int index = getHouseIndex(delID);
        if (index == -1) // 房屋列表为空或寻找ID不存在
            return false;
        // 将房源信息依次前移
        for (int i = index; i < houseNum - 1; i++) {
            // 避免空指针
            if (houseList[i] == null) break;
            houseList[i] = houseList[i + 1]; // 将前面的房源信息覆盖
        }

        // 删除列表最后的信息，并将房源数量-1
        houseList[--houseNum] = null;
        return true;
    }

    /*
     * 更新房源信息
     * 返回类型 boolean
     *
     *  */
    public boolean update(int updateID, House newHouse) {
        // 获取 ID 对应的 house
        House house = findHouse_ID(updateID);
        if (house == null)
            return false;

        house.setName(newHouse.getName());
        house.setAddress(newHouse.getAddress());
        house.setPhone(newHouse.getPhone());
        house.setRent(newHouse.getRent());
        house.setState(newHouse.getState());
        return true;
    }


    /* 寻找房屋ID对应的下标
     *  返回类型 int
     *  ID存在 返回当前房屋ID对应的下标
     *  ID不存在 返回-1
     *  */
    public int getHouseIndex(int houseID) {
        for (int i = 0; i < houseNum; i++) {
            if (houseID == houseList[i].getId())
                return i; // 返回当前ID对应记录的下标
        }
        return -1; // 未找到当前ID对应的记录 返回-1
    }

    /*
     * 寻找房屋ID对应的信息
     * 返回类型 House
     * */
    public House findHouse_ID(int findID) {
        int index = getHouseIndex(findID); // 获取 ID 对应的下标
        if (index == -1) {
            return null;
        }
        return houseList[index];
    }


}
