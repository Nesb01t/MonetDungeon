# MonetDungeon

用于 QuantumBreak RPG 服务器的地牢传送控制和奖励插件

支持 Spigot 1.14.4 使用

# 地图锁定
由于设计初期需要，地牢的入口和出口直接根据玩家坐标进行识别

X轴 (-500, 500) 为第0个副本，(500, 1500) 为第1个副本，以此类推
# 指令使用

### 管理员指令 (OP)
`/loc save <区块> <层级>`
保存 0-N 区块中的 1-3 层级副本传送坐标

`/dun`
打开你所在副本的地牢坐标管理 GUI 面板