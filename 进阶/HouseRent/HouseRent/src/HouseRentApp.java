import utils.Utility;
import view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        // 创建HouseView对象，并且显示主菜单
        new HouseView().mainMenu();
        Utility.closeScanner();
    }
}
