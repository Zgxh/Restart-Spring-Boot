spring security中三种登录的账户配置：
1. 在 application.properties 中配置 name 和 password
2. 通过创建java配置类，继承 `WebSecurityConfigurerAdapter` ，然后重写 `configure()` 方法。
3. 从数据库加载

spring security 提供了安全校验类来进行密码加密和匹配.

```java
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

可以单独设置忽略拦截某个url。

可以配置登录成功的响应、失败的响应、重定向的url等。