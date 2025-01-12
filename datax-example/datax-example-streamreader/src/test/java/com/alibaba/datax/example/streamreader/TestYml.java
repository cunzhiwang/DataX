package com.alibaba.datax.example.streamreader;


import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class TestYml {

    @Test
    public void test() throws IOException, SQLException {
        File file = new File("/Users/admin/project/DataX/" + "datax-example/datax-example-streamreader/src/test/resources/sharding/application.yml");
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(file);
    }
}
