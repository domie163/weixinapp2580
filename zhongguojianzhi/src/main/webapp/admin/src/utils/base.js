const base = {
    get() {
        return {
            url : "http://localhost:8080/zhongguojianzhi/",
            name: "zhongguojianzhi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhongguojianzhi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "中国剪纸微信小程序"
        } 
    }
}
export default base
