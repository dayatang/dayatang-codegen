说明：
这是一个产品订单金额和税金计算程序。

订单Order是主要的领域类。它记录下订单的客户，以及所订购的订单项。

订单项OrderItem是单个的订单项目，记录所订购的产品，其数量以及折扣率（有些产品是打折的）。

产品Product为简单起见，只记录名称和单价。

客户Client分金牌、银牌、VIP和普通客户四个级别。不同级别的客户，其订单金额可以打不同的
折扣率。


订单计算器OrderCalculator是主类。负责计算订单的金额和税金。订单金额会根据客户级别进行打折。
