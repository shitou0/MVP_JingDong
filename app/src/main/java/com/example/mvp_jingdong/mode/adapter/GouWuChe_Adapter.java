package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.custom.MyAdd_Sub_View;
import com.example.mvp_jingdong.http.SumUtils;
import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;
import com.example.mvp_jingdong.view.GouWu_IMyView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 利用  二级列表  进项适配器展示
 * Created by 石头 on 2018/4/2.
 */

public class GouWuChe_Adapter extends BaseExpandableListAdapter {


    //    Context context;
//    List<GoodsCartBean.DataBean> list;
//
//    public MyExpandableGoodsCartAdapter(Context context, List<GoodsCartBean.DataBean> list, IGoodsCart iGoodsCart) {
//        this.context = context;
//        this.list = list;
//        this.iGoodsCart = iGoodsCart;
//    }
    private final GouWu_IMyView gouWu_iMyView;
    private Context context;
    private List<GouWuChe_Bean.DataBean> gouwuche_list;

    public GouWuChe_Adapter(Context context, List<GouWuChe_Bean.DataBean> gouwuche_list, GouWu_IMyView gouWu_iMyView) {
        this.context = context;
        this.gouwuche_list = gouwuche_list;
        this.gouWu_iMyView = gouWu_iMyView;
    }


    @Override
    public int getGroupCount() {
        return gouwuche_list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return gouwuche_list.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return gouwuche_list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return gouwuche_list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        MyParentViewHolder myParentViewHolder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.gouwuche_fulei_item, null);
            CheckBox parent_cb = view.findViewById(R.id.parent_cb);
            TextView parent_tv = view.findViewById(R.id.parent_tv);
            myParentViewHolder = new MyParentViewHolder(parent_cb, parent_tv);
            view.setTag(myParentViewHolder);
        } else {
            myParentViewHolder = (MyParentViewHolder) view.getTag();
        }
        myParentViewHolder.getParent_tv().setText(gouwuche_list.get(i).getSellerName());
        myParentViewHolder.getParent_cb().setChecked(gouwuche_list.get(i).isParentSelectedIsChecked());
        //父布局的点击事件
        myParentViewHolder.getParent_cb().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean selected = gouwuche_list.get(i).isParentSelectedIsChecked();
                selected = !selected;
                gouwuche_list.get(i).setParentSelectedIsChecked(selected);
                //点击父条目的复选框，子条目相应的改变
                //                将复选框的状态赋给子条目
                List<GouWuChe_Bean.ChildBean> list1 = GouWuChe_Adapter.this.gouwuche_list.get(i).getList();
                for (int x = 0; x < list1.size(); x++) {
                    GouWuChe_Bean.ChildBean childBean = list1.get(x);
                    childBean.setChildSelectedIsChecked(selected);
                }
                notifyDataSetChanged();
                //选中时计算价钱

                String sum = SumUtils.sum(gouwuche_list);
                gouWu_iMyView.showCount(sum);
            }

        });
        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        MyChildViewHolder myChildViewHolder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.gouwuche_zilei_item, null);
            CheckBox child_cb = view.findViewById(R.id.child_cb);
            SimpleDraweeView child_icon = view.findViewById(R.id.child_icon);
            TextView child_title = view.findViewById(R.id.child_title);
            TextView child_price = view.findViewById(R.id.child_price);
            MyAdd_Sub_View child_add_sub = view.findViewById(R.id.child_add_sub);
            myChildViewHolder = new MyChildViewHolder(child_cb, child_icon, child_title, child_price, child_add_sub);
            view.setTag(myChildViewHolder);
        } else {
            myChildViewHolder = (MyChildViewHolder) view.getTag();
        }

        String child_icon_url = gouwuche_list.get(i).getList().get(i1).getImages().split("\\|")[0];
        myChildViewHolder.getChild_icon().setImageURI(child_icon_url);
        myChildViewHolder.getChild_title().setText(gouwuche_list.get(i).getList().get(i1).getTitle());
        myChildViewHolder.getChild_price().setText(gouwuche_list.get(i).getList().get(i1).getPrice() + "");
        myChildViewHolder.getChild_sub_add().setContent(gouwuche_list.get(i).getList().get(i1).getNum());
        myChildViewHolder.getChild_cb().setChecked(gouwuche_list.get(i).getList().get(i1).isChildSelectedIsChecked());
        //设置加减按钮的监听事件
        myChildViewHolder.getChild_sub_add().SetAddClickListener(new MyAdd_Sub_View.AddClickListener() {
            @Override
            public void onAddClick(View view, int count) {
                gouwuche_list.get(i).getList().get(i1).setNum(count);
                boolean checked = gouwuche_list.get(i).getList().get(i1).isChildSelectedIsChecked();
                if (checked) {
                    String sum = SumUtils.sum(gouwuche_list);
                    gouWu_iMyView.showCount(sum);
                }
            }
        });
        //减去
        myChildViewHolder.getChild_sub_add().SetSubClickListener(new MyAdd_Sub_View.SubClickListener() {
            @Override
            public void onSubClick(View view, int count) {
                gouwuche_list.get(i).getList().get(i1).setNum(count);
                //判断选中状态如果选中就计算，没选中，就不计算
                boolean checked = gouwuche_list.get(i).getList().get(i1).isChildSelectedIsChecked();
                if (checked) {
                    //计算价钱
                    String sum = SumUtils.sum(gouwuche_list);
                    gouWu_iMyView.showCount(sum);
                }

            }
        });
        //子布局的点击事件
        myChildViewHolder.getChild_cb().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean childIsSelected = gouwuche_list.get(i).getList().get(i1).isChildSelectedIsChecked();
                childIsSelected = !childIsSelected;
                gouwuche_list.get(i).getList().get(i1).setChildSelectedIsChecked(childIsSelected);

                //当所有子条目被选中，所有父条目也被选中，如果有一个子条目没选中，父条目就不能被选中
                List<GouWuChe_Bean.ChildBean> list2 = GouWuChe_Adapter.this.gouwuche_list.get(i).getList();
                boolean flag = true;
                for (int j = 0; j < list2.size(); j++) {
                    if (!list2.get(j).isChildSelectedIsChecked()) {
                        flag = false;
                    }
                }
                gouwuche_list.get(i).setParentSelectedIsChecked(flag);
                //刷新
                notifyDataSetChanged();
                //选中时计算价钱
                String sum = SumUtils.sum(gouwuche_list);
                gouWu_iMyView.showCount(sum);
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class MyParentViewHolder {
        CheckBox parent_cb;
        TextView parent_tv;

        public MyParentViewHolder(CheckBox parent_cb, TextView parent_tv) {
            this.parent_cb = parent_cb;
            this.parent_tv = parent_tv;
        }

        public CheckBox getParent_cb() {
            return parent_cb;
        }

        public void setParent_cb(CheckBox parent_cb) {
            this.parent_cb = parent_cb;
        }

        public TextView getParent_tv() {
            return parent_tv;
        }

        public void setParent_tv(TextView parent_tv) {
            this.parent_tv = parent_tv;
        }
    }

    class MyChildViewHolder {
        CheckBox child_cb;
        SimpleDraweeView child_icon;
        TextView child_title;
        TextView child_price;
        MyAdd_Sub_View child_sub_add;

        public MyChildViewHolder(CheckBox child_cb, SimpleDraweeView child_icon, TextView child_title, TextView child_price, MyAdd_Sub_View child_sub_add) {
            this.child_cb = child_cb;
            this.child_icon = child_icon;
            this.child_title = child_title;
            this.child_price = child_price;
            this.child_sub_add = child_sub_add;
        }

        public CheckBox getChild_cb() {
            return child_cb;
        }

        public void setChild_cb(CheckBox child_cb) {
            this.child_cb = child_cb;
        }

        public SimpleDraweeView getChild_icon() {
            return child_icon;
        }

        public void setChild_icon(SimpleDraweeView child_icon) {
            this.child_icon = child_icon;
        }

        public TextView getChild_title() {
            return child_title;
        }

        public void setChild_title(TextView child_title) {
            this.child_title = child_title;
        }

        public TextView getChild_price() {
            return child_price;
        }

        public void setChild_price(TextView child_price) {
            this.child_price = child_price;
        }

        public MyAdd_Sub_View getChild_sub_add() {
            return child_sub_add;
        }

        public void setChild_sub_add(MyAdd_Sub_View child_sub_add) {
            this.child_sub_add = child_sub_add;
        }
    }

}
