## 使用说明：

目录说明：

>code.zip			  源码包
<br /><br />
SalesManagerment	  源码包解压后目录
<br /><br />
salesmanagement.sql  数据库脚本
<br /><br />
设计说明书.doc 	      设计说明书
<br /><br />

使用注意：

>0.使用**Java Swing**开发
<br /><br />
1.在数据库中运行根目录的**salesmanagement.sql**脚本 （默认会创建名为“salesmanagement”的数据库，并导入数据，若默认创建不了，则需手动创建名为“salesmanagement"的数据库，再运行该SQL脚本）
<br /><br />
2.**myeclipse 10**（用该IDE开发）导入工程的源码
<br /><br />
3.在myeclipse中修改根目录的jdbc.properties文件，username和password改成自己数据库的用户和密码
<br /><br />
4.找到下图的类 右键 Run as Java Application 即可
![avatar](https://github.com/1275563227/MarkdownPhotos/blob/master/sale/swing/help.png)

## 运行后界面图：

**首页**
![avatar](https://github.com/1275563227/MarkdownPhotos/blob/master/sale/swing/show1.png)
<br/><br/>
**基础数据**
![avatar](https://github.com/1275563227/MarkdownPhotos/blob/master/sale/swing/show2.png)
<br/><br/>
**进销存管理**
![avatar](https://github.com/1275563227/MarkdownPhotos/blob/master/sale/swing/show3.png)
<br/><br/>
**用户股那里**
![avatar](https://github.com/1275563227/MarkdownPhotos/blob/master/sale/swing/show4.png)
<br/><br/>

## 数据库说明：

>根据功能需求分析，要有一个用户表，用户具有id、姓名、密码、身份标识四个属性，用于登陆系统；
<br /><br />
而整个销售管理系统的核心是商品，那么就产生的商品表，商品表拥有id、姓名、价格、产地、库存、所属仓库、所属分类、删除标识八个属性；
<br /><br />
而商品与仓库、分类均为多对一的逻辑关系，那么就产生了仓库表和分类表，仓库表具有id、名称、删除标识、排序规则四个属性，分类表具有id、名称、删除标识三个属性；
<br /><br />
在销售管理过程中，势必会生成订单，根据功能需求分析，首先要将商品入库，这样就生成了入库单，入库单具有id、订单号、经手人id、商品所属仓库id、商品所属分类id、入库数量、商品id、删除标识八个属性；
<br /><br />
而在销售中，每有一笔生意，就会生成销售单，需要建立销售表，销售单具有id、订单号、经手人id、商品所属仓库id、商品所属分类id、销售数量、商品id、删除标识八个属性；
<br /><br />
在商品销售以及库存调动中又会涉及到出库，这样就生成了出库单，出库单具有id、订单号、经手人id、商品所属仓库id、商品所属分类id、出库数量、商品id、删除标识八个属性，为了数据交互性能的提升，将入库单与出库单合并产生出入库表，他们各自多了一条属性，即出入库标识；
