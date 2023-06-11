import router from '@/router/index'

router.beforeEach((to,from,next)=>{
    let token=window.sessionStorage.getItem("token");
    console.log("token="+token);
    console.log("to.path="+to.path);
    const whiteList=['/login']
    if(token){
        if(to.path=="/login"){ // 如果是登录请求
            next("/");
        }else{
            next(); // 放行
        }
    }else{
        if(whiteList.includes(to.path)){
            next(); // 放行
        }else{
            next("/login") // 跳转登录页面
        }
    }
})