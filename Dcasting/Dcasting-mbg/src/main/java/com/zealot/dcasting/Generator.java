package com.zealot.dcasting;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用於生產MBG的代碼
 * Created by LeoLiu on 2020/6/4.
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //MBG 執行過程中的警告信息
        List<String> warnings = new ArrayList<String>();
        //當生成的代碼重複時，覆蓋原代碼
        boolean overwrite = true;
        //讀取我們的 MBG 配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //創建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //執行生成代碼
        myBatisGenerator.generate(null);
        //輸出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
