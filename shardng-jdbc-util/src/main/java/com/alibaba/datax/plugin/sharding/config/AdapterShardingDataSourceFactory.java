package com.alibaba.datax.plugin.sharding.config;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cunzhiwang
 */
public class AdapterShardingDataSourceFactory {

    private static final Logger logger = LoggerFactory.getLogger(AdapterShardingDataSourceFactory.class);
    private static final String shardingPrefix = "spring.shardingsphere";
    private final static String dataSourcePrefix = "spring.shardingsphere.datasource.";


    /**
     * 根据配置文件获取sharding jdbc dataSource
     *
     * @param configDir
     * @return dataSource
     * @throws SQLException sql异常
     * @throws IOException  io异常
     */
    //使用入口
    public static DataSource newInstance(File configDir) throws SQLException, IOException {
        File yamlFile = ShardingConfigLoader.loadYamlFile(configDir);
        return YamlShardingSphereDataSourceFactory.createDataSource(yamlFile);

    }


}
