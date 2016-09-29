`# mongodb-learn
mongodb 学习随笔

# mongodb command (bin/mongo)
**1 连接**<br />
  连接到指定实例 mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]<br />
  eg:mongodb://fred:foobar@localhost/baz<br />
**2 创建数据库**<br />
  use DATABASE_NAME （如果数据库不存在，则创建数据库，否则切换到指定数据库。）<br />
  查看当前数据库 db<br />
  查看所有数据库 show dbs<br />
  MongoDB 中默认的数据库为 test<br />
**3 删除数据库** db.dropDatabase()<br />
**4 删除集合** db.COLLECTION_NAME.drop()<br />
**5 插入文档** db.COLLECTION_NAME.insert(document)<br />
  插入文档你也可以使用 db.col.save(document) 命令。如果不指定 _id 字段 save() 方法类似于 insert() 方法。如果指定 _id 字段，则会更新该 _id 的数据。<br />
  eg:>db.col.insert({title: 'MongoDB 教程',
         description: 'MongoDB 是一个 Nosql 数据库',
         by: '菜鸟教程',
         url: 'http://www.runoob.com',
         tags: ['mongodb', 'database', 'NoSQL'],
         likes: 100
     })<br />
**6 更新文档** MongoDB 使用 update() 和 save() 方法来更新集合中的文档。接下来让我们详细来看下两个函数的应用及其区别。<br/>
db.collection.update(
   \<query>, _//update的查询条件，类似sql update查询内where后面的。_<br />
   \<update>, _//update的对象和一些更新的操作符（如$,$inc...）等，也可以理解为sql update查询内set后面的_<br />
   {
     upsert: \<boolean>,_//可选，这个参数的意思是，如果不存在update的记录，是否插入objNew,true为插入，默认是false，不插入。_<br />
     multi: \<boolean>,_//可选，mongodb 默认是false,只更新找到的第一条记录，如果这个参数为true,就把按条件查出来多条记录全部更新_。<br />
     writeConcern: \<document> _//可选，抛出异常的级别。_<br />
   }
)<br/>
**7 删除文档**
db.collection.remove(
   <query>, //_（可选）删除的文档的条件。_<br/>
   {
     justOne: <boolean>,_//（可选）如果设为 true 或 1，则只删除一个文档。_<br/>
     writeConcern: <document>_//（可选）抛出异常的级别。_<br/>
   }
)
**8 查询文档**
db.COLLECTION_NAME.find()<br/>
未完.....
# mongodb vs spring
**1 mvn deploy**
    \<dependency>
        \<groupId>org.mongodb\</groupId>
        \<artifactId>mongo-java-driver\</artifactId>
        \<version>2.9.3\</version>
    \</dependency>
    \<dependency>
        \<groupId>org.springframework.data\</groupId>
        \<artifactId>spring-data-commons\</artifactId>
        \<version>1.7.2.RELEASE\</version>
    \</dependency>
    \<dependency>
        \<groupId>org.springframework.data\</groupId>
        \<artifactId>spring-data-mongodb\</artifactId>
        \<version>1.4.2.RELEASE\</version>
    \</dependency>

`