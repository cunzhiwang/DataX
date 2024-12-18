package com.alibaba.datax.plugin.sharding.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.shardingsphere.encrypt.yaml.config.YamlEncryptRuleConfiguration;

/**
 * @author cunzhiwang
 */
public class SpringShardingConfiguration {
    /**
     * 前缀"spring.shardingsphere.encrypt" 对应 YamlEncryptRuleConfiguration
     * 前缀"spring.shardingsphere.masterslave" 对应 YamlMasterSlaveRuleConfiguration
     * 前缀"spring.shardingsphere.sharding" 对应 YamlShardingRuleConfiguration
     **/
    private YamlEncryptRuleConfiguration encrypt;

    private DatasourceDto datasource;

    private Properties props = new Properties();


    public YamlEncryptRuleConfiguration getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(YamlEncryptRuleConfiguration encrypt) {
        this.encrypt = encrypt;
    }


    public DatasourceDto getDatasource() {
        return datasource;
    }

    public void setDatasource(DatasourceDto datasource) {
        this.datasource = datasource;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }


    public static class DatasourceDto {
        private List<String> names;
        private Map<String, DataSource> dataSources = new HashMap();

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        public Map<String, DataSource> getDataSources() {
            return dataSources;
        }

        public void setDataSources(Map<String, DataSource> dataSources) {
            this.dataSources = dataSources;
        }
    }
}


