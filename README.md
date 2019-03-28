# blog  www.wnatao.xyz
技术与环境:<br/>
前端:bootstrap+jquery+ajax<br/>
后端:spring+springmvc+mybatis<br/>
权限管理:shiro<br/>
项目管理:maven<br/>
数据库:mysql5.7.25<br/>
开发工具:eclipse<br/>


<a href="http://www.wnatao.xyz" target="_blank">点击这里预览网站前台</a><br>
网站后台截图:
<img src="https://github.com/wantao666/blog/blob/master/result/1.png"/>
<img src="https://github.com/wantao666/blog/blob/master/result/2.png"/>
<img src="https://github.com/wantao666/blog/blob/master/result/3.png"/>
<img src="https://github.com/wantao666/blog/blob/master/result/4.png"/>


项目目录结构:详细目录结构 tree.txt
```
.
├── blog_old.sql
├── blog.sql
├── blog.txt
├── log
│   └── blog.log
├── pom.xml
├── README.md
├── result
│   ├── 1.png
│   ├── 2.png
│   ├── 3.png
│   └── 4.png
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── wantao
│   │   │           ├── bean
│   │   │           ├── controller
│   │   │           ├── filter
│   │   │           ├── mapper
│   │   │           ├── service
│   │   │           ├── shiro
│   │   │           └── util
│   │   ├── resources
│   │   │   ├── db.properties
│   │   │   ├── ehcache.xml
│   │   │   ├── log4j.properties
│   │   │   ├── mapper
│   │   │   │   ├── ArticleCategoryRefMapper.xml
│   │   │   │   ├── ArticleMapper.xml
│   │   │   │   ├── ArticleTagRefMapper.xml
│   │   │   │   ├── CategoryMapper.xml
│   │   │   │   ├── CommentMapper.xml
│   │   │   │   ├── ContactMapper.xml
│   │   │   │   ├── MeMapper.xml
│   │   │   │   ├── MessageMapper.xml
│   │   │   │   ├── TagMapper.xml
│   │   │   │   └── UserMapper.xml
│   │   │   ├── mybatis
│   │   │   │   └── mybatis-config.xml
│   │   │   └── spring
│   │   │       ├── spring-mybatis.xml
│   │   │       ├── spring-shiro.xml
│   │   │       ├── spring-springmvc.xml
│   │   │       └── spring.xml
│   │   └── webapp
│   │       ├── resource
│   │       │   ├── admin
│   │       │   │   ├── selenium
│   │       │   │   ├── template1
│   │       │   │   └── template2
│   │       │   ├── avatar
│   │       │   │   ├── 1.jpeg
│   │       │   │   ├── 1.jpg
│   │       │   │   ├── 20190216173815.jpg
│   │       │   │   ├── 33.jpeg
│   │       │   │   ├── avatar0.jpg
│   │       │   │   ├── avatar.jpg
│   │       │   │   ├── dog1.jpeg
│   │       │   │   ├── java.jpg
│   │       │   │   ├── logo.png
│   │       │   │   └── we_20190214193621.jpg
│   │       │   ├── file
│   │       │   ├── image
│   │       │   │   ├── 1552546380466_820x200.png
│   │       │   │   ├── 1552546380466.jpg
│   │       │   │   ├── 1552546919167.jpg
│   │       │   │   ├── 1553001405703078528.jpeg
│   │       │   │   ├── 404_bg.png
│   │       │   │   ├── 5girls_820x200.png
│   │       │   │   ├── 5girls.jpg
│   │       │   │   └── logo.icon
│   │       │   ├── tag
│   │       │   │   ├── 1.jpeg
│   │       │   │   ├── 1.jpg
│   │       │   │   ├── dog1.jpeg
│   │       │   │   ├── java.jpg
│   │       │   │   └── language.jpg
│   │       │   ├── ueditor
│   │       │   │   └── utf8-jsp
│   │       │   ├── user
│   │       │   │   ├── selenium
│   │       │   │   ├── template1
│   │       │   │   ├── template2
│   │       │   │   ├── template3
│   │       │   │   ├── template4
│   │       │   │   └── template5
│   │       │   └── video
│   │       └── WEB-INF
│   │           ├── lib
│   │           │   ├── commons-codec-1.9.jar
│   │           │   ├── commons-fileupload-1.3.1.jar
│   │           │   ├── commons-io-2.4.jar
│   │           │   ├── json.jar
│   │           │   └── ueditor-1.1.2.jar
│   │           ├── views
│   │           │   ├── admin
│   │           │   └── user
│   │           └── web.xml
│   └── test
│       └── java
│           └── com
│               └── wantao
│                   └── test
├── target
│   ├── classes
│   │   ├── com
│   │   │   └── wantao
│   │   │       ├── bean
│   │   │       │   ├── ArticleCategoryRef.class
│   │   │       │   ├── Article.class
│   │   │       │   ├── ArticleTageRef.class
│   │   │       │   ├── Category.class
│   │   │       │   ├── Comment.class
│   │   │       │   ├── Contact.class
│   │   │       │   ├── Me.class
│   │   │       │   ├── Message.class
│   │   │       │   ├── Photo.class
│   │   │       │   ├── Tag.class
│   │   │       │   └── User.class
│   │   │       ├── controller
│   │   │       │   ├── AdminController.class
│   │   │       │   └── UserController.class
│   │   │       ├── filter
│   │   │       │   └── UrlFilter.class
│   │   │       ├── mapper
│   │   │       │   ├── ArticleCategoryRefMapper.class
│   │   │       │   ├── ArticleMapper.class
│   │   │       │   ├── ArticleTagRefMapper.class
│   │   │       │   ├── CategoryMapper.class
│   │   │       │   ├── CommentMapper.class
│   │   │       │   ├── ContactMapper.class
│   │   │       │   ├── MeMapper.class
│   │   │       │   ├── MessageMapper.class
│   │   │       │   ├── TagMapper.class
│   │   │       │   └── UserMapper.class
│   │   │       ├── service
│   │   │       │   ├── ArticleCategoryRefService.class
│   │   │       │   ├── ArticleService.class
│   │   │       │   ├── ArticleTagRefService.class
│   │   │       │   ├── CategoryService.class
│   │   │       │   ├── CommentService.class
│   │   │       │   ├── ContactService.class
│   │   │       │   ├── MeService.class
│   │   │       │   ├── MessageService.class
│   │   │       │   ├── TagService.class
│   │   │       │   └── UserService.class
│   │   │       ├── shiro
│   │   │       │   └── MyRealm.class
│   │   │       └── util
│   │   │           ├── HtmlUtil.class
│   │   │           ├── Message.class
│   │   │           └── PhotoUtil.class
│   │   ├── db.properties
│   │   ├── ehcache.xml
│   │   ├── log4j.properties
│   │   ├── mapper
│   │   │   ├── ArticleCategoryRefMapper.xml
│   │   │   ├── ArticleMapper.xml
│   │   │   ├── ArticleTagRefMapper.xml
│   │   │   ├── CategoryMapper.xml
│   │   │   ├── CommentMapper.xml
│   │   │   ├── ContactMapper.xml
│   │   │   ├── MeMapper.xml
│   │   │   ├── MessageMapper.xml
│   │   │   ├── TagMapper.xml
│   │   │   └── UserMapper.xml
│   │   ├── mybatis
│   │   │   └── mybatis-config.xml
│   │   └── spring
│   │       ├── spring-mybatis.xml
│   │       ├── spring-shiro.xml
│   │       ├── spring-springmvc.xml
│   │       └── spring.xml
│   ├── m2e-wtp
│   │   └── web-resources
│   │       └── META-INF
│   │           ├── MANIFEST.MF
│   │           └── maven
│   │               └── com.wantao
│   └── test-classes
│       └── com
│           └── wantao
│               └── test
│                   ├── ArticleCategoryRefMapperTest.class
│                   ├── ArticleMapperTest.class
│                   ├── ArticleTagRefMapperTest.class
│                   ├── ContactMapperTest.class
│                   ├── MessageMapperTest.class
│                   └── UserMapperTest.class
└── tree.txt
```
