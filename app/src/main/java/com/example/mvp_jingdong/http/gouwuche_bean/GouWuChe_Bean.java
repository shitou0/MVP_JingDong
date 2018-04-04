package com.example.mvp_jingdong.http.gouwuche_bean;

import java.util.List;

/**
 * Created by 石头 on 2018/4/1.
 */

public class GouWuChe_Bean {

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String sellerName;
        private String sellerid;
        private List<ChildBean> list;
        private boolean ParentSelectedIsChecked;

        public DataBean(boolean parentSelectedIsChecked) {
            ParentSelectedIsChecked = parentSelectedIsChecked;
        }


        public String getSellerName() {
            return sellerName;
        }

        public boolean isParentSelectedIsChecked() {
            return ParentSelectedIsChecked;
        }

        public void setParentSelectedIsChecked(boolean parentSelectedIsChecked) {
            ParentSelectedIsChecked = parentSelectedIsChecked;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<ChildBean> getList() {
            return list;
        }

        public void setList(List<ChildBean> list) {
            this.list = list;
        }
    }

  public   class  ChildBean {
        private double bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int num;
        private int pid;
        private double price;
        private int pscid;
        private int selected;
        private int sellerid;
        private String subhead;
        private String title;

      private boolean ChildSelectedIsChecked;

      public boolean isChildSelectedIsChecked() {
          return ChildSelectedIsChecked;
      }

      public void setChildSelectedIsChecked(boolean childSelectedIsChecked) {
          ChildSelectedIsChecked = childSelectedIsChecked;
      }

      public ChildBean(boolean childSelectedIsChecked) {

          ChildSelectedIsChecked = childSelectedIsChecked;
      }

      public double getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(double bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public int getSellerid() {
            return sellerid;
        }

        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }

        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
