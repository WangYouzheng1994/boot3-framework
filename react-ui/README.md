### React17
 
react17 官方教程  
https://17.reactjs.org/docs/getting-started.html

### Umi3.x
https://v3.umijs.org/zh-CN/docs/runtime-config#patchroutes-routes-

### 启动
* Node：建议v16或以上

* 升级npm
```
npm install -g npm
```
* 安装依赖 方法一

```
npm install --registry=https://registry.npmmirror.com
```

* 如果出现依赖冲突的问题，是因为升级了npm 导致依赖有冲突
```
方案1
npm i --registry=https://registry.npmmirror.com --legacy-peer-deps 不覆盖依赖
方案2
npm i --registry=https://registry.npmmirror.com --force  强制从远端拉取新覆盖依赖
```
---
### Umi 3.x说明
1. umi默认的配置文件是工程根目录下的 .umirc.ts文件，实际项目中拆分到/config目录下
2. umi的 /src/pages/document.ejs 等价于react中的 public/index.html
3. 


---
# Ant Design Pro

This project is initialized with [Ant Design Pro](https://pro.ant.design). Follow is the quick guide for how to use.

## Environment Prepare

Install `node_modules`:

```bash
npm install
```

or

```bash
yarn
```

## Provided Scripts

Ant Design Pro provides some useful script to help you quick start and build with web project, code style check and test.

Scripts provided in `package.json`. It's safe to modify or add additional script:

### Start project

正常启动请运行
npm start:dev

Mock测试模式请运行
npm start
```

### Build project

```bash
npm run build
```

### Check code style

```bash
npm run lint
```

You can also use script to auto fix some lint error:

```bash
npm run lint:fix
```

### Test code

```bash
npm test
```

## More

You can view full document on our [official website](https://pro.ant.design). And welcome any feedback in our [github](https://github.com/ant-design/ant-design-pro).




####

围绕路由踩的坑
https://webliuyang.com/react/problem/Umi%E6%A1%86%E6%9E%B6%E5%8A%A8%E6%80%81%E8%B7%AF%E7%94%B1.html

umi框架
https://v3.umijs.org/zh-CN/plugins/plugin-layout

此项目对应的 antd pro
https://v4-pro.ant.design/index-cn

此对应了 布局框架插件
https://procomponents.ant.design/components/layout
