package com.example.imagecure.imagecure;

import java.util.ArrayList;

/**
 * Created by hilarydeng on 12/11/15.
 */
public class ImageSet_cat{


    private ArrayList<ArrayList<String>> emotions;
    private ArrayList<String> images;

    /**
     * This class generates an 2D arraylist to hold pictures
     * For every button there is an arraylist of pictures accordingly
     * This class serves as the picture resource for the cat preference
     */
    public ImageSet_cat() {
        emotions =  new ArrayList<ArrayList<String>>();
        images = new ArrayList<String>();
        populateImageSet();
    }

    private void populateImageSet() {
        //Button #happy
        images.add("https://40.media.tumblr.com/3364137b6e5b1afbf92ad9d9119eec83/tumblr_mzzhtsjWad1stlkgho1_1280.jpg");
        images.add("http://ww3.sinaimg.cn/large/9b60d56cjw1eyp2f4z8snj218w0u07c0.jpg");
        images.add("http://ww4.sinaimg.cn/large/69c76a90jw1eyo3h1vmluj215o1jk15w.jpg");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1eyvxkpk254g20a305k7wj.gif");
        images.add("http://imgsrc.baidu.com/forum/pic/item/a316f736afc379314b936e07eac4b74542a9110f.jpg");
        images.add("https://scontent.cdninstagram.com/hphotos-xpf1/t51.2885-15/s640x640/sh0.08/e35/12345997_1509995102634123_310660836_n.jpg");
        images.add("https://scontent.cdninstagram.com/hphotos-xap1/t51.2885-15/s640x640/sh0.08/e35/11264876_919160788166870_256590769_n.jpg");
        images.add("https://fs01.androidpit.info/a/42/20/funny-cute-cat-wallpaper-4220ac-h900.jpg");
        images.add("http://media-cache-ak0.pinimg.com/736x/14/f2/33/14f2335568fee0164ae1a9c465654269.jpg");
        emotions.add(images);

        //Button #stressed
        images = new ArrayList<String>();
        images.add("http://ww2.sinaimg.cn/large/005vaCFkgw1exr38cs4dqj30ri0q9th3.jpg");
        images.add("http://ww4.sinaimg.cn/large/005vaCFkgw1ey3slb1s0ej32io3s07wj.jpg");
        images.add("http://photo.weibo.com/5041262490/wbphotos/large/mid/3915185859260775/pid/005vaCFkgw1eyjxzar3jaj317i1t9e81\n");
        images.add("http://ww2.sinaimg.cn/large/005vaCFkjw1ewc7tjiklaj31w01lxkjn.jpg");
        images.add("http://ww1.sinaimg.cn/large/9b60d56cjw1eytsjxpwavj215o1jkqgl.jpg");
        images.add("http://photo.weibo.com/5041262490/wbphotos/large/mid/3915996542525477/pid/005vaCFkgw1eymiy2dw6aj327u27v4qr");
        images.add("http://ww3.sinaimg.cn/mw1024/69c76a90jw1eyw6fpzcr2j215o1jk7lo.jpg");
        images.add("http://ww2.sinaimg.cn/large/69c76a90jw1eytr3go68kj215o1jkqn5.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1ey22jc2g4ug207h0dahdt.gif");
        emotions.add(images);

        //Button #angry
        images = new ArrayList<String>();
        images.add("http://ww3.sinaimg.cn/large/005vaCFkgw1eylbqqjgb8j31ow1m6npf.jpg");
        images.add("http://ww2.sinaimg.cn/large/005vaCFkgw1ex1tr32xypj312c12cnpd.jpg");
        images.add("http://ww2.sinaimg.cn/mw690/005vaCFkgw1ex1tr32xypj312c12cnpd.jpg");
        images.add("http://ww4.sinaimg.cn/large/005vaCFkjw1evw4br2x38j31jk2bkqv6.jpg");
        images.add("http://ww1.sinaimg.cn/mw690/005vaCFkjw1evw4bz6vhlj31jk2bku0y.jpg");
        images.add("http://ww1.sinaimg.cn/cmw218/69c76a90gw1eyc08kyjsgg205k03xgx9.gif");
        images.add("http://ww4.sinaimg.cn/bmiddle/5cfc088egw1ey9s1vp6kkj20d60hsac7.jpg");
        images.add("http://ww4.sinaimg.cn/large/006iAPgFgw1eyupupwymmg30b406yx6p.gif");
        emotions.add(images);

        //Button #excited
        images = new ArrayList<String>();
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1elqo9lzspfg2069068npd.gif");
        images.add("http://ww3.sinaimg.cn/large/78111478gw1evzwt319rkg208u0b4x6p.gif");
        images.add("http://ww2.sinaimg.cn/large/006czPLdgw1evrvynniwag305c074wt6.gif");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1eyul01hm1yg208c06inp3.gif");
        images.add("http://imgsrc.baidu.com/forum/pic/item/4ac597dda144ad34ecc86fa9d1a20cf430ad8594.jpg");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1eyul01hm1yg208c06inp3.gif");
        images.add("http://imgsrc.baidu.com/forum/pic/item/2838b48f8c5494ee2ce5e7372cf5e0fe9b257ec4.jpg");
        images.add("http://imgsrc.baidu.com/forum/pic/item/7f247d1ed21b0ef4073e7070dcc451da80cb3e34.jpg");
        images.add("http://ww1.sinaimg.cn/mw1024/bcc93f49gw1eyghjrdrurg209d04ukjl.gif");
        images.add("http://imgsrc.baidu.com/forum/pic/item/2838b48f8c5494ee2ce5e7372cf5e0fe9b257ec4.jpg");
        emotions.add(images);

        //Button #nervous
        images = new ArrayList<String>();
        images.add("http://ww2.sinaimg.cn/large/005vaCFkgw1eythfu7xx4j31b91b9wmg.jpg");
        images.add("http://ww3.sinaimg.cn/large/005vaCFkgw1ex8sv9rl4nj33s02iokjs.jpg");
        images.add("http://ww2.sinaimg.cn/mw690/005vaCFkgw1ex1tqv10apj312d12chdt.jpg");
        images.add("http://ww2.sinaimg.cn/large/005vaCFkjw1ew5u2x97hej312d12ce81.jpg");
        images.add("http://ww1.sinaimg.cn/large/69c76a90gw1eylkafbpuug20640644je.gif");
        images.add("http://ww3.sinaimg.cn/large/005vaCFkgw1ex8sv9rl4nj33s02iokjs.jpg");
        images.add("http://ww3.sinaimg.cn/large/bcc93f49gw1ey7so3s9z5j20gl0giwij.jpg");
        emotions.add(images);

        //Button #sad
        images = new ArrayList<String>();
        images.add("http://imgsrc.baidu.com/forum/w%3D580/sign=ac78d2ad0e2442a7ae0efdade143ad95/d4c242a7d933c895e36a7055d01373f0830200ea.jpg");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eynlbk4errj20is0ir0z4.jpg");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eyi22pvlytj20dw0dw0to.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1eyisgge20lj20hs0hmdit.jpg");
        images.add("http://ww1.sinaimg.cn/large/bcc93f49gw1eyi23jszj6g206k06mnpd.gif");
        images.add("http://ww4.sinaimg.cn/large/bcc93f49gw1eyisgk8memj20hs0hedj3.jpg");
        emotions.add(images);

    }

    public String getImage(int i, int j) {
        return emotions.get(i).get(j);
    }

    public ArrayList<String> getEmotionSet (int i) {
        return emotions.get(i);
    }


}



