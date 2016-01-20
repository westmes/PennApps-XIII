package com.example.imagecure.imagecure;

import java.util.ArrayList;

/**
 * Created by hilarydeng on 12/11/15.
 */
public class ImageSet_dog {
    private ArrayList<ArrayList<String>> emotions;
    private ArrayList<String> images;

    public ImageSet_dog() {
        emotions =  new ArrayList<ArrayList<String>>();
        images = new ArrayList<String>();
        populateImageSet();
    }

    private void populateImageSet() {
    //Button #happy
        images.add("http://ww4.sinaimg.cn/mw1024/bcc93f49gw1eyumc7khgeg20b40bdak0.gif");
        images.add("http://ww4.sinaimg.cn/mw1024/bcc93f49gw1eyl6vvy490g209e058npd.gif");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eyd6ejdkk3g205y05x4qq.gif");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1eyd6iosrkbg205y05xkjl.gif");
        images.add("http://cdn.duitang.com/uploads/item/201504/10/20150410H1949_HdA53.jpeg");
        images.add("http://ww1.sinaimg.cn/bmiddle/5a1c4ce7gw1eyqait3lfrj21kw2dc1ky.jpg");
        images.add("http://ww4.sinaimg.cn/bmiddle/5a1c4ce7gw1ey8vxtoi0mj21kw2dcx6p.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1ey8pcfwjbxj20gp0gpdjh.jpg");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1ey42wddpdlj20zk0nptd8.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1ey0igaeb9yj20g60vkjvd.jpg");
        emotions.add(images);

        //Button #stressed
        images = new ArrayList<String>();
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1eytn5tn31vg205704xu0x.gif");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eydmce08qlj20hs0hhgm7.jpg");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eydenmbfm7g205g05akjo.gif");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1eyc10n3jyrj20gn0gmtbz.jpg");
        images.add("http://ww3.sinaimg.cn/bmiddle/b04b5c1agw1ey8jg6tv4gj20rs0rsn29.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1exy7fpgoryg207p07pu0z.gif");
        images.add("http://ww2.sinaimg.cn/large/bcc93f49gw1exyaw592yyj20hs0hj40k.jpg");
        images.add("http://s3.amazonaws.com/barkpost-assets/50+GIFs/17.gif");
        emotions.add(images);

        //Button #angry
        images = new ArrayList<String>();
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1eyfi76c61xj20gn0gjdjj.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1ey9pt0etw3j20dw0afjsm.jpg");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1ey7ejcbunig206g06jqv6.gif");
        images.add("http://ww4.sinaimg.cn/large/005vaCFkjw1evw4br2x38j31jk2bkqv6.jpg");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1ey6msedk0nj20fa0kdt9g.jpg");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1extzx1ir4sj20hs0hk41u.jpg");
        images.add("https://media.giphy.com/media/GZFnSNxnE92g0/giphy.gif");
        images.add("https://media.giphy.com/media/JegNHhf3Rb0ha/giphy.gif");
        emotions.add(images);

        //Button #excited
        images = new ArrayList<String>();
        images.add("http://ww3.sinaimg.cn/mw1024/bcc93f49gw1eyl6wie9n2g209e058b2a.gif");
        images.add("http://cdn.duitang.com/uploads/item/201504/04/20150404H4448_j4PFT.thumb.700_0.jpeg");
        images.add("http://ww2.sinaimg.cn/large/006czPLdgw1evrvynniwag305c074wt6.gif");
        images.add("http://ww3.sinaimg.cn/mw1024/bcc93f49gw1ey6g1oi5vjg206l06jhdu.gif");
        images.add("http://ww3.sinaimg.cn/mw1024/bcc93f49gw1ey0d4kzk4jg204n06e1ky.gif");
        images.add("http://ww3.sinaimg.cn/mw690/bcc93f49gw1exyaw52dc8j20hs0hj0ud.jpg");
        images.add("http://ww2.sinaimg.cn/large/bcc93f49gw1exy3kwetwbg205a06khdt.gif");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1expxjt3w9yg206w06rnpd.gif");
        images.add("http://ww1.sinaimg.cn/mw1024/bcc93f49gw1expxjt3w9yg206w06rnpd.gif");
        emotions.add(images);

        //Button #nervous
        images = new ArrayList<String>();
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eymtmm7akbj21ci129n5v.jpg");
        images.add("http://ww3.sinaimg.cn/mw1024/bcc93f49gw1ey6mshdnzzj20fa0kdmxu.jpg");
        images.add("http://ww2.sinaimg.cn/mw690/005vaCFkgw1ex1tqv10apj312d12chdt.jpg");
        images.add("http://ww2.sinaimg.cn/mw1024/bcc93f49gw1exrm8z8gh1g2083087npd.gif");
        images.add("https://media.giphy.com/media/Zjh6QaLwGVs4/giphy.gif");
        images.add("http://ww3.sinaimg.cn/large/005vaCFkgw1ex8sv9rl4nj33s02iokjs.jpg");
        images.add("https://media.giphy.com/media/fpXxIjftmkk9y/giphy.gif");
        emotions.add(images);

        //Button #sad
        images = new ArrayList<String>();
        images.add("https://media.giphy.com/media/gYB4tZO3triBG/giphy.gif");
        images.add("https://media.giphy.com/media/3o85xKWxQi1cQ59q2k/giphy.gif");
        images.add("https://media.giphy.com/media/11nQ2iZnQpPkgo/giphy.gif");
        images.add("https://media.giphy.com/media/MuztdWJQ4PR7i/giphy.gif");
        images.add("https://media.giphy.com/media/naS93ZG3DUhuE/giphy.gif");
        images.add("https://media.giphy.com/media/MAtKCGwJHblVC/giphy.gif");
        images.add("https://media.giphy.com/media/11nQ2iZnQpPkgo/giphy.gif");
        images.add("https://media.giphy.com/media/L5WQjD4p8IpO0/giphy.gif");
        emotions.add(images);

    }

    public String getImage(int i, int j) {
        return emotions.get(i).get(j);
    }

}






