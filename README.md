## Addax

[![Release](https://img.shields.io/github/v/release/jitwxs/addax.svg)](https://github.com/jitwxs/addax/releases)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

为简化测试用例开发而生，基于 Java SE 开发，引入 Jar 包即可使用。

### 使用指南

使用文档将在主要功能开发完毕且稳定后编写，如您有需要，可查看 `addax-sample` 项目测试用例。

### 项目依赖

你可能需要注意，引入 Addax 所带来的依赖影响: 

- [fastjson](https://github.com/alibaba/fastjson): 用于处理 JSON 相关逻辑

- [mockito](https://github.com/mockito/mockito) 用于实现部分特定功能

- [mybatis](https://github.com/mybatis/mybatis-3) 用于实现 Mapper Verify 功能

### 开发进度

目前处于 Beta 阶段，待稳定后发布 Release 版本，暂定会实现的主要功能如下。

(1) 公共模块 Publiv Module

- [x] 所有主要模块支持 SPI 的横向扩展

(2) 数据加载模块 Data Loader Module 

- [x] 支持本地 CSV 文件解析
- [ ] 支持本地 JSON 文件解析
- [x] 支持远程 SELECT SQL 语句执行结果
- [ ] 支持本地 INSERT 文件解析
  
(3) 数据转换模块 Data Convert Module

- [x] 支持全部基本数据类型与 String 的转换
- [ ] 支持常用原生数据类型与 String 的转换
- [x] 支持复杂对象与 String 的转换
- [x] 对 protobuf 对象的支持

(4) 数据生成模块 Data Mock Module

- [ ] 支持基本数据类型的生成
- [ ] 支持复杂对象的生成，自动填充属性
- [ ] 支持对集合、Map 的支持
- [ ] 对 protobuf 对象的支持

(5) 数据验证模块 Data Verify Module

- [ ] 支持基本数据类型间的比较
- [ ] 支持复杂对象的比较
- [ ] 支持对集合、Map 的对象支持
- [ ] 对 protobuf 对象的支持

(6) MyBatis Mapper Verify Module

- [ ] 支持校验 ResultMap 和查询字段是否完全匹配
- [ ] 支持校验 ResultMap 与对应 POJO 实体字段是否完全匹配
- [ ] 支持简单的 SQL 语句静态校验
