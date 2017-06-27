# GreenDao3Demo
GreenDao3.2的使用，仿购物车和购买者清单demo

# 效果图

![这里写图片描述](http://img.blog.csdn.net/20170627152534080?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxNDYyNDI0MQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

# 主要说明
## 1.真正的引入步骤，亲测无误
### 1.1在projoct的build.gradle里
```
dependencies {
        classpath 'com.android.tools.build:gradle:2.2.2'
        //GreenDao3
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
```
### 1.2在app build.gradle里
```
apply plugin: 'com.android.application'
apply plugin: 'org.greenrobot.greendao'

android {
    compileSdkVersion 23
    buildToolsVersion "25.0.2"

    defaultConfig {
        applicationId "com.hensen.greendaodemo"
        minSdkVersion 16
        targetSdkVersion 23
        versionCode 1
        versionName "1.0"
    }
    //greendao配置
    greendao {
        //版本号，升级时可配置
        schemaVersion 1
        //生成dao的路径
        daoPackage 'com.hensen.greendaodemo'
        targetGenDir 'src/main/java'
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.4.0'
    //ORM数据库
    compile 'org.greenrobot:greendao:3.2.2'
    //这是一步很关键呀
    compile'org.greenrobot:greendao-generator:3.0.0'
    compile files('libs/xUtils-2.6.14.jar')
}
```

# 更多内容见csdn博文
[greendao3 使用和源码分析 ](http://blog.csdn.net/u014624241/article/details/73740748)



# 感谢（博主的我编译总是报错，不能创建dao）
[Android实战——GreenDao3.2的使用，爱不释手](https://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650821932&idx=1&sn=d26c09af7cbbfb1b0a95517bd78cc784&chksm=80b781b2b7c008a4a8dab45756e4d433b1c56e1c61762f98ee3b8a2b89a00756f82d6bb4d6b6&scene=0#rd)


