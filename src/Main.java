import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 资料
     */
    private static List<HashMap<String,String>> data = new ArrayList<>();
    /**
     * 库存
     */
    private static List<HashMap<String,String>> goods = new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            HashMap<String,String> item = new HashMap<>();
            item.put("code","测试"+i);
            item.put("name","测试"+i);
            item.put("brand","测试"+i);
            item.put("price","测试"+i);
            data.add(item);
        }

        for (int i = 0; i < 10; i++) {
            HashMap<String,String> item = new HashMap<>();
            item.put("code","测试"+i);
            item.put("name","测试"+i);
            item.put("num",i+"");
            item.put("price",i+"");
            goods.add(item);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用电脑配件库存管理系统!");
        menuSelect(scanner);
    }

    private static void menuSelect(Scanner scanner){
        System.out.println("请选择功能(输入数字)!");
        System.out.println("1.配件资料管理;2.进货、退货、出货管理;3.库存管理;4.信息统计;5.退出系统");
        int functionType = scanner.nextInt();
        switch (functionType){
            case 1:
                queryInfoMenu(scanner);
                break;
            case 2:
                goodsMenu(scanner);
                break;
            case 3:
                goodsQueryMenu(scanner);
                break;
            case 4:break;
            case 5:
                System.exit(0);
                break;
            default:break;
        }
    }


    private static void queryInfoMenu(Scanner scanner){
        System.out.println("全部配件资料如下");
        List<HashMap<String, String>> hashMaps = queryInfo();
        for (HashMap<String, String> hashMap : hashMaps) {
            String info = "配件编码:"+hashMap.get("code")+";配件名称:"+hashMap.get("name")+";品牌:"+hashMap.get("brand")+";价格:"+hashMap.get("price")+";";
            System.out.println(info);
        }
        System.out.println("请选择功能(输入数字)!");
        System.out.println("1.新增;2.修改;3.删除,4.返回上一层菜单5.退出系统");
        int type2 = scanner.nextInt();
        switch (type2){
            case 1:
                addInfoMenu(scanner);
                break;
            case 2:
                updateInfoMenu(scanner);
                break;
            case 3:
                deleteInfoMenu(scanner);
                break;
            case 4:
                menuSelect(scanner);
                break;
            case 5:
                System.exit(0);
                break;
            default:break;
        }
    }

    private static void addInfoMenu(Scanner scanner){
        System.out.println("请输入配件编码:");
        String code = scanner.next();
        System.out.println("请输入配件名称:");
        String name = scanner.next();
        System.out.println("请输入品牌:");
        String brand = scanner.next();
        System.out.println("请输入价格:");
        String price = scanner.next();
        System.out.println("新增成功");
        addInfo(code,name,brand,price);
        queryInfoMenu(scanner);
    }

    public static void updateInfoMenu(Scanner scanner){
        System.out.println("请输入配件编码:");
        String code = scanner.next();
        System.out.println("请输入配件名称:");
        String name = scanner.next();
        System.out.println("请输入品牌:");
        String brand = scanner.next();
        System.out.println("请输入价格:");
        String price = scanner.next();
        updateInfo(code,name,brand,price);
        System.out.println("修改成功");
        queryInfoMenu(scanner);
    }

    public static void deleteInfoMenu(Scanner scanner){
        System.out.println("请输入配件编码:");
        String code = scanner.next();
        deleteInfo(code);
        System.out.println("删除成功");
        queryInfoMenu(scanner);
    }

    /**
     * 查询所有资料
     * @return
     */
    private static List<HashMap<String,String>> queryInfo(){
        return data;
    }

    /**
     * 添加资料
     * @param code
     * @param name
     * @param brand
     * @param price
     */
    private static void addInfo(String code,String name,String brand,String price){
        HashMap<String,String> item = new HashMap<>();
        item.put("code",code);
        item.put("name",name);
        item.put("brand",brand);
        item.put("price",price);
        data.add(item);
    }

    /**
     * 修改资料
     * @param code
     * @param name
     * @param brand
     * @param price
     */
    private static void updateInfo(String code,String name,String brand,String price){
        for (HashMap<String, String> item : data) {
            if (item.get("code").equals(code)){
                item.put("name",name);
                item.put("brand",brand);
                item.put("price",price);
                break;
            }
        }

    }

    /**
     * 删除资料
     * @param code
     */
    private static void deleteInfo(String code){
        for (int i = 0; i < data.size(); i++) {
            HashMap<String, String> item = data.get(i);
            if (item.get("code").equals(code)){
                data.remove(item);
                break;
            }
        }
    }

    private static void goodsMenu(Scanner scanner){
        System.out.println("请选择功能(输入数字)!");
        System.out.println("1.进货;2.退货;3.出货,4.返回上一层菜单5.退出系统");
        int type2 = scanner.nextInt();
        switch (type2){
            case 1:
                buyGoodsMenu(scanner);
                break;
            case 2:
                backGoodsMenu(scanner);
                break;
            case 3:
                sellGoodsMenu(scanner);
                break;
            case 4:
                menuSelect(scanner);
                break;
            case 5:
                System.exit(0);
                break;
            default:break;
        }
    }

    /**
     * 进货
     * @param scanner
     */
    private static void buyGoodsMenu(Scanner scanner){
        System.out.println("请输入配件编码:");
        String code = scanner.next();
        System.out.println("请输入配件名称:");
        String name = scanner.next();
        System.out.println("请输入进货件数:");
        String num = scanner.next();
        System.out.println("请输入总价格:");
        String price = scanner.next();
        buyGoods(code,name,num,price);
        System.out.println("进货成功");
        goodsMenu(scanner);
    }

    private static void buyGoods(String code,String name,String num,String price){
        boolean flag = false;
        for (HashMap<String, String> item : goods) {
            if (code.equals(item.get("code"))){
                item.put("num",String.valueOf(Integer.parseInt(item.get("num"))+Integer.parseInt(num)));
                item.put("price",String.valueOf(Integer.parseInt(item.get("price"))+Integer.parseInt(price)));
                flag = true;
                break;
            }
        }
        if (!flag){
            HashMap<String, String> item = new HashMap<>();
            item.put("code",code);
            item.put("name",name);
            item.put("num",String.valueOf(Integer.parseInt(num)));
            item.put("price",String.valueOf(Integer.parseInt(price)));
        }
    }

    /**
     * 退货
     * @param scanner
     */
    private static void backGoodsMenu(Scanner scanner){
        System.out.println("请输入配件编码:");
        String code = scanner.next();
        System.out.println("请输入配件名称:");
        String name = scanner.next();
        System.out.println("请输入退货件数:");
        String num = scanner.next();
        System.out.println("请输入总价格:");
        String price = scanner.next();
        boolean flag = backGoods(code, name, num, price);
        if (!flag){
            System.err.println("未找到对应的配件信息，请重新操作");
        }else{
            System.out.println("退货成功");
        }
        goodsMenu(scanner);
    }

    private static boolean backGoods(String code,String name,String num,String price){
        boolean flag = false;
        for (HashMap<String, String> item : goods) {
            if (code.equals(item.get("code"))){
                item.put("num",String.valueOf(Integer.parseInt(item.get("num"))+Integer.parseInt(num)));
                item.put("price",String.valueOf(Integer.parseInt(item.get("price"))+Integer.parseInt(price)));
                flag = true;
                break;
            }
        }
        return flag;

    }

    /**
     * 出货
     * @param scanner
     */
    private static void sellGoodsMenu(Scanner scanner){
        System.out.println("请输入配件编码:");
        String code = scanner.next();
        System.out.println("请输入配件名称:");
        String name = scanner.next();
        System.out.println("请输入出货件数:");
        String num = scanner.next();
        System.out.println("请输入总价格:");
        String price = scanner.next();

        boolean flag = sellGoods(code, name, num, price);
        if (!flag){
            System.err.println("库存不足，请先进货");
        }else{
            System.out.println("出货成功");
        }
        goodsMenu(scanner);
    }

    private static boolean sellGoods(String code,String name,String num,String price){
        boolean flag = false;
        for (HashMap<String, String> item : goods) {
            if (code.equals(item.get("code"))){
                if (Integer.parseInt(item.get("num")) > Integer.parseInt(num)){
                    item.put("num",String.valueOf(Integer.parseInt(item.get("num"))-Integer.parseInt(num)));
                    item.put("price",String.valueOf(Integer.parseInt(item.get("price"))-Integer.parseInt(price)));
                    flag = true;
                }
                break;
            }
        }
        return flag;
    }

    private static void goodsQueryMenu(Scanner scanner){
        System.out.println("请选择功能(输入数字)!");
        System.out.println("1.查看库存;4.返回上一层菜单5.退出系统");
        int type2 = scanner.nextInt();
        switch (type2){
            case 1:
                System.out.println("全部配件资料如下");
                List<HashMap<String, String>> hashMaps = goodsQuery();
                for (HashMap<String, String> hashMap : hashMaps) {
                    String info = "配件编码:"+hashMap.get("code")+";配件名称:"+hashMap.get("name")+";库存数:"+hashMap.get("num")+";总价格:"+hashMap.get("price")+";";
                    System.out.println(info);
                }
                menuSelect(scanner);
                break;
            case 4:
                menuSelect(scanner);
                break;
            case 5:
                System.exit(0);
                break;
            default:break;
        }
    }

    private static List<HashMap<String,String>> goodsQuery(){
        return goods;
    }


}
