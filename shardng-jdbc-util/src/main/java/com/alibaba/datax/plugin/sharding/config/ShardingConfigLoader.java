package com.alibaba.datax.plugin.sharding.config;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cunzhiwang
 */
public class ShardingConfigLoader {

    private static Logger logger = LoggerFactory.getLogger(ShardingConfigLoader.class);
//  private final static String configDir="rdb-sharding";


    public static File loadYamlFile(File configDirFile) {
        // File configDirFile=Util.getConfDirPath(configDir);
        final String yaml = "yaml";
        final String yml = "yml";

        File[] yamlFiles = configDirFile.listFiles((dir, name) -> name.endsWith(yaml) || name.endsWith(yml));


        if (yamlFiles == null || yamlFiles.length == 0) {
            throw new RuntimeException("Can not find yaml File in location '" + configDirFile.getAbsolutePath() + "'");
        }

        if (yamlFiles.length > 1) {
            logger.warn("found {} yaml files in '{}', use the first one", yamlFiles.length, configDirFile.getName());
            sortFileByName(yamlFiles);
        }

        File yarmlFile = yamlFiles[0];
        logger.info(" the rdb-sharding yaml file location is '{}' ", yarmlFile.getAbsoluteFile());
        return yarmlFile;

    }

    /**
     * 文件目录文件根据文件名排序
     *
     * @param files 文件夹下属文件
     * @return 排序结果
     */

    private static File[] sortFileByName(File[] files) {
        List<File> fileList = Arrays.asList(files);
        fileList.sort(Comparator.comparing(File::getName));
        fileList.toArray(files);
        return files;
    }


}
