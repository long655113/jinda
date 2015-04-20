package org.trustel.runtime;

import java.util.Date;

/**
*
* 类 名：抽象版本信息
*
* 版 本：0.0.0.1
*
* 设 计：万志勇
*
* 日 期：2010-03-01 14:40
*
* 描 述：
*
**/

public class AbstractVersion {
    /**
    *编码
    */
    private  String code;
    /**
    *所属子系统/模块
    */
    private  String ucode;
    /**
    *名称
    */
    private  String name;
    /**
    *标题
    */
    private  String title;
    /**
    *描述
    */
    private  String description;
    /**
    *发布日期
    */
    private  Date deploy;
    /**
    *序号
    */
    private  int seq=0;
    /**
    *
    * @return 编码(code)
    */
    public  String getCode(){
        return code;
    }
    /**
    *
    * @return 所属子系统/模块(ucode)
    */
    public  String getUcode(){
        return ucode;
    }
    /**
    *
    * @return 名称(name)
    */
    public  String getName(){
        return name;
    }
    /**
    *
    * @return 标题(title)
    */
    public  String getTitle(){
        return title;
    }
    /**
    *
    * @return 描述(description)
    */
    public  String getDescription(){
        return description;
    }
    /**
    *
    * @return 发布日期(deploy)
    */
    public  Date getDeploy(){
        return deploy;
    }
    /**
    *
    * @return 序号(seq)
    */
    public  int getSeq(){
        return seq;
    }
    /**
    *设置编码
    *@param 编码(code)
    */
    public void setCode( String code){
        this.code=code;
    }
    /**
    *设置所属子系统/模块
    *@param 所属子系统/模块(ucode)
    */
    public void setUcode( String ucode){
        this.ucode=ucode;
    }
    /**
    *设置名称
    *@param 名称(name)
    */
    public void setName( String name){
        this.name=name;
    }
    /**
    *设置标题
    *@param 标题(title)
    */
    public void setTitle( String title){
        this.title=title;
    }
    /**
    *设置描述
    *@param 描述(description)
    */
    public void setDescription( String description){
        this.description=description;
    }
    /**
    *设置发布日期
    *@param 发布日期(deploy)
    */
    public void setDeploy( Date deploy){
        this.deploy=deploy;
    }
    /**
    *设置序号
    *@param 序号(seq)
    */
    public void setSeq( int seq){
        this.seq=seq;
    }
}

