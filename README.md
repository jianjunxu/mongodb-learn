# mongodb-learn
mongodb 学习随笔

# mongodb command (bin/mongo)
1 连接
  连接到指定实例 mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
  eg:mongodb://fred:foobar@localhost/baz

2 创建数据库
  use DATABASE_NAME （如果数据库不存在，则创建数据库，否则切换到指定数据库。）
  查看当前数据库 db
  查看所有数据库 show dbs
  MongoDB 中默认的数据库为 test
3 删除数据库 db.dropDatabase()
4 删除集合 db.COLLECTION_NAME.drop()
5 插入文档 db.COLLECTION_NAME.insert(document)
  插入文档你也可以使用 db.col.save(document) 命令。如果不指定 _id 字段 save() 方法类似于 insert() 方法。如果指定 _id 字段，则会更新该 _id 的数据。
  eg:>db.col.insert({title: 'MongoDB 教程',
         description: 'MongoDB 是一个 Nosql 数据库',
         by: '菜鸟教程',
         url: 'http://www.runoob.com',
         tags: ['mongodb', 'database', 'NoSQL'],
         likes: 100
     })
6