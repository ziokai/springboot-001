package easyexcel;

import com.alibaba.excel.EasyExcel;
import com.zou.easyexcel.DemoData;
import com.zou.easyexcel.DemoDataListener;
import org.junit.jupiter.api.Test;

public class EasyExcelReadTest {

    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName =  "D:/TestEasyExcel.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }

}
