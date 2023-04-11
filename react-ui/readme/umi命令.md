### UMI_ENV
当指定 UMI_ENV 时，会额外加载指定值的配置文件，优先级为：
```
config.ts

config.${UMI_ENV}.ts

config.${dev | prod | test}.ts

config.${dev | prod | test}.${UMI_ENV}.ts

config.local.ts
```

> 若不指定 UMI_ENV ，则只会加载当前环境对应的配置文件，越向下的越具体，优先级更高，高优的配置可以往下移动。

* 注：根据当前环境的不同，dev, prod, test 配置文件会自动加载，不能将 UMI_ENV 的值设定成他们。

### umi dev
启动本地开发服务器
