package org.trustel.runtime;

import java.util.Date;

/**
*
* �� ��������汾��Ϣ
*
* �� ����0.0.0.1
*
* �� �ƣ���־��
*
* �� �ڣ�2010-03-01 14:40
*
* �� ����
*
**/

public class AbstractVersion {
    /**
    *����
    */
    private  String code;
    /**
    *������ϵͳ/ģ��
    */
    private  String ucode;
    /**
    *����
    */
    private  String name;
    /**
    *����
    */
    private  String title;
    /**
    *����
    */
    private  String description;
    /**
    *��������
    */
    private  Date deploy;
    /**
    *���
    */
    private  int seq=0;
    /**
    *
    * @return ����(code)
    */
    public  String getCode(){
        return code;
    }
    /**
    *
    * @return ������ϵͳ/ģ��(ucode)
    */
    public  String getUcode(){
        return ucode;
    }
    /**
    *
    * @return ����(name)
    */
    public  String getName(){
        return name;
    }
    /**
    *
    * @return ����(title)
    */
    public  String getTitle(){
        return title;
    }
    /**
    *
    * @return ����(description)
    */
    public  String getDescription(){
        return description;
    }
    /**
    *
    * @return ��������(deploy)
    */
    public  Date getDeploy(){
        return deploy;
    }
    /**
    *
    * @return ���(seq)
    */
    public  int getSeq(){
        return seq;
    }
    /**
    *���ñ���
    *@param ����(code)
    */
    public void setCode( String code){
        this.code=code;
    }
    /**
    *����������ϵͳ/ģ��
    *@param ������ϵͳ/ģ��(ucode)
    */
    public void setUcode( String ucode){
        this.ucode=ucode;
    }
    /**
    *��������
    *@param ����(name)
    */
    public void setName( String name){
        this.name=name;
    }
    /**
    *���ñ���
    *@param ����(title)
    */
    public void setTitle( String title){
        this.title=title;
    }
    /**
    *��������
    *@param ����(description)
    */
    public void setDescription( String description){
        this.description=description;
    }
    /**
    *���÷�������
    *@param ��������(deploy)
    */
    public void setDeploy( Date deploy){
        this.deploy=deploy;
    }
    /**
    *�������
    *@param ���(seq)
    */
    public void setSeq( int seq){
        this.seq=seq;
    }
}

