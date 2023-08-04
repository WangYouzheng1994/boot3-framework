/* *
 *
 * @author whiteshader@163.com
 * @datetime  2022/02/15
 *
 * */

import type { Settings as LayoutSettings } from '@ant-design/pro-layout';
import { PageLoading, SettingDrawer } from '@ant-design/pro-layout';
import type { RunTimeLayoutConfig } from 'umi';
import {dynamic} from 'umi';
import { history, Link } from 'umi';
import RightContent from '@/components/RightContent';
import Footer from '@/components/Footer';
import { BookOutlined, LinkOutlined } from '@ant-design/icons';
import defaultSettings from '../config/defaultSettings';
import { getUserInfo, getRoutersInfo } from './services/session';
import LoadingComponent from "@ant-design/pro-layout/es/PageLoading";
import KeepAlive from '@/components/KeepAlive';
import TabsLayout from '@/layouts/TabsLayout'
import Wyz from '@/pages/system/wyz'
// import React from "react";

const isDev = process.env.NODE_ENV === 'development';
const loginPath = '/user/login';

/** 获取用户信息比较慢的时候会展示一个 loading */
export const initialStateConfig = {
  loading: <PageLoading />,
};

/**
 * @see  https://umijs.org/zh-CN/plugins/plugin-initial-state
 * */
export async function getInitialState(): Promise<{
  settings?: Partial<LayoutSettings>;
  currentUser?: API.CurrentUser;
  loading?: boolean;
  fetchUserInfo?: () => Promise<API.CurrentUser | undefined>;
}> {
  const fetchUserInfo = async () => {
    try {
      const resp = await getUserInfo();
      if(resp === undefined || resp.code !== 200) {
        history.push(loginPath);
      } else {
        return { ...resp.user, permissions: resp.permissions } as API.CurrentUser;
      }
    } catch (error) {
      history.push(loginPath);
    }
    return undefined;
  };
  // 如果是登录页面，不执行
  if (history.location.pathname !== loginPath) {
    const currentUser = await fetchUserInfo();
    return {
      settings: defaultSettings,
      currentUser,
      fetchUserInfo,
    };
  }
  return {
    fetchUserInfo,
    settings: defaultSettings,
  };
}

export function patchRoutes ({ routes }) {
  // console.log(routes,"123", routeComponents);
  /*const newVar = await import('@/layouts/TabsLayout');
  console.log("++++++++++++++++", newVar.default);
  console.log("22222222", (await import('@/pages/system/wyz/index')).default)*/
  // console.log("------------", routes);
  // console.log((await require('@/pages/system/wyz/index')).default);
  // console.log(async () => await import('@/pages/system/wyz/index'));
  console.log(routes)
  // console.log(dynamic({loader: () => import('@/pages/system/wyz/index.tsx')}));
  // console.log( dynamic({loader: () => import(`@/pages/system/wyz/index`)}));
  // require(`@/pages/system/wyz`).then((rst) => console.log(rst))
  // console.log("123", require('@/pages/system/wyz'));
  // 动态添加路由
  routes[1].routes.unshift(
  // routes.push(
    {
      path: '/wyz',
      name:'wyz',
      // exact: false,
      // icon: 'BugOutlined',
      layout: false,
      // component: require('@/layouts/TabsLayout').default,
      // component: (await import('@/layouts/TabsLayout')).default,
      // component: ('@/layouts/TabsLayout'),
      // component:  (async() =>  await import('@/layouts/TabsLayout')),
      // component: dynamic({loader: () => import('@/layouts/TabsLayout'), loading: LoadingComponent}),
      // component: TabsLayout,
      routes: [
        /*{
          path: '/wyz',
          redirect: '/wyz/test',
        },*/
        {
          path: '/wyz/test',
          name: 'wyztest123',
          icon: 'BugOutlined',
          /*component: (await import('@/pages/system/wyz/index')).default,
          wrappers: [(await import('@/components/KeepAlive')).default],*/
          // component: (require('@/pages/system/wyz/index')).default,
          // wrappers: [require('@/components/KeepAlive').default],
          /*component: '@/pages/system/wyz/index',*/
          // wrappers: ['@/components/KeepAlive'],
/*          component:  (async () => await import('@/pages/system/wyz/index')),
          wrappers: [ async () => await import('@/components/KeepAlive')],*/
          component:  dynamic({loader: () => import('@/pages/system/wyz'), loading: LoadingComponent}),
          // component:  Wyz,
          // wrappers: [ dynamic({loader: () => import('@/components/KeepAlive'), loading: LoadingComponent})],
          wrappers: [ KeepAlive],
          keepAlive: true,
          exact: true,
          title: '王有政测试',
          access: "authorize",
        }/*,
        {
          path: '/wyz/dynamic',
          name: 'dynamic',
          component: 'system/wyz/index',
          wrappers: ['@/components/KeepAlive'],
          KeepAlive: true,
          access: 'authorize',
          title: '王有政测试dynamic'
        },*/

      ]
    }
  )
  // console.log("123123123", routes)
}

/*
const mergeRoutes = async function (routes, parentRoute) => {
  if (!Array.isArray(routes)) return [];
  return routes.map(route => {
    if (route.path) {
      route.path = route.path.startsWith('/')
        ? route.path
        : `${parentRoute?.path || ''}/${route.path}`;
    }
    if (route.component) {
      route.component = (component => {
        if (typeof component === 'function') {
          return component;
        }
        // eslint-disable-next-line global-require, import/no-dynamic-require, prefer-template
        return await import('./pages/' + component.substr(component.indexOf('/') + 1)).default;
      })(route.component);
    }
    if (route.routes) {
      route.routes = mergeRoutes(route.routes, route);
    }
    return route;
  });
};*/

export function render(oldRender) {
  // alert("123")
  oldRender();
}

// ProLayout 支持的api https://procomponents.ant.design/components/layout
export const layout: RunTimeLayoutConfig = ({ initialState, setInitialState }) => {
  return {
    rightContentRender: () => <RightContent />,
    waterMarkProps: {
      content: initialState?.currentUser?.userName,
    },
    footerRender: () => <Footer />,
    onPageChange: () => {
      const { location } = history;
      // 如果没有登录，重定向到 login
      if (!initialState?.currentUser && location.pathname !== loginPath) {
        history.push(loginPath);
      }
    },
    links: isDev
      ? [
          <Link key="openapi" to="/umi/plugin/openapi" target="_blank">
            <LinkOutlined />
            <span>OpenAPI 文档</span>
          </Link>,
          <Link key="docs" to="/~docs">
            <BookOutlined />
            <span>业务组件文档</span>
          </Link>,
        ]
      : [],
    menuHeaderRender: undefined,
    menu: {
      // 每当 initialState?.currentUser?.userid 发生修改时重新执行 request
      params: {
        userId: initialState?.currentUser?.userId,
      },
      request: async () => {
        if (!initialState?.currentUser?.userId) {
          return [];
        }
        // initialState.currentUser 中包含了所有用户信息
        const menus = await getRoutersInfo();
        debugger;
        setInitialState((preInitialState) => ({
          ...preInitialState,
          menus,
        }));
        return menus;
      },
      locale: false,
    },
    // 自定义 403 页面
    // unAccessible: <div>unAccessible</div>,
    // 增加一个 loading 的状态
    childrenRender: (children, props) => {
      return (
        <div>
          {children}
          {!props.location?.pathname?.includes('/login') && (
            <SettingDrawer
              enableDarkTheme
              settings={initialState?.settings}
              onSettingChange={(settings) => {
                setInitialState((preInitialState) => ({
                  ...preInitialState,
                  settings,
                }));
              }}
            />
          )}
        </div>
      );
    },
    ...initialState?.settings,
  };
};
