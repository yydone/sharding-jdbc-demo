package com.yydone.demo.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Properties;

@Slf4j
@Component
public class HashPreciseShardingAlgorithm  implements StandardShardingAlgorithm<String>  {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String splitKey = preciseShardingValue.getValue();
        String tableSuffix = splitKey.substring(splitKey.length()-2);
        log.info("分表键:{}, 表后缀:{}",splitKey,tableSuffix);
        String selectTableName = null;
        for (String tableName : collection) {
            if (tableName.endsWith(tableSuffix)){
                selectTableName= tableName;
                break;
            }
        }
        if(StringUtils.isNotBlank(selectTableName)){
            return selectTableName;
        }
        log.error("根据分表键:{}选表异常",splitKey);
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        return collection;
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "HASH";
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void setProps(Properties properties) {

    }
}
