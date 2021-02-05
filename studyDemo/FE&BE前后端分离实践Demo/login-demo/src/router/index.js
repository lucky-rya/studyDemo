import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import App from '../App'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: '图书管理',
        component: Home,
        redirect: '/searchbook',
        children: [{
                path: '/searchbook',
                name: '查询图书',
                component: () =>
                    import ( /* webpackChunkName: "searchbook" */ '../views/searchBook.vue')
            },
            {
                path: '/addbook',
                name: '添加图书',
                component: () =>
                    import ( /* webpackChunkName: "addbook" */ '../views/addBook.vue')
            }
        ]
    },
    {
        path: '/navigation',
        name: '导航二',
        component: Home,
        children: [{
            path: '/pageThree',
            name: '选项三',
            component: () =>
                import ( /* webpackChunkName: "pageThree" */ '../views/pageThree.vue')
        }, {
            path: '/pageFour',
            name: '选项四',
            component: () =>
                import ( /* webpackChunkName: "pageFour" */ '../views/pageFour.vue')
        }]
    },
    // {
    //     path: '/book',
    //     name: 'Book',
    //     component: Book
    // },
    // {
    //     path: '/about',
    //     name: 'About',
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () =>
    //         import ( /* webpackChunkName: "about" */ '../views/About.vue')
    // }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router