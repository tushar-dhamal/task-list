package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomId {

    Map<Long, String> customIdMap = new LinkedHashMap<>();



    public Map<Long,String> getCustomTaskMap() {
        return this.customIdMap;
    }

    public String getCustomTaskIdIfPresent(long id) {
        String idString = this.customIdMap.get(id);
        if(idString!=null)
            return idString;
        else
            return String.valueOf(id);

    }


    public void setId(Long id, String idString) {

        if(!idString.chars().anyMatch(s->s==' ') && !Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]").matcher(idString).find())
            this.customIdMap.put(id, idString);

    }

    public Long getKeyId(String valueId) {
        Map.Entry<Long,String> map = this.customIdMap.entrySet().stream().filter(s -> s.getValue().equals(valueId)).findFirst().get();
        if(map!=null) return map.getKey();
        else return null;
    }


}
