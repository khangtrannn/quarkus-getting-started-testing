### Notes
- `ArC` comes as a dependency of `quarkus-resteasy-reactive` so you already have it handy
- `@Mock` is built-in stereotype declares `@Alternative`, `@Priority(1)`, `@Dependent`
- `@InjeckMock` works on normal scope CDI beans (@ApplicationScoped, @RequestScoped, etc.)

### Fetures
- Transactional test with Stereotype
- Test Profile
- Runing specific tests profile with tags
- QuarkusTestResourceLifecycleManager 
- QuarkusTest*Callback
- WireMock
```
<dependency>
  <groupId>com.github.tomakehurst</groupId>
  <artifactId>wiremock-jre8</artifactId>
  <version>2.28.0</version>
  <scope>test</scope>
</dependency>
```



### Reference
https://quarkus.io/guides/getting-started-testing
https://www.youtube.com/watch?v=OCPFdpvL1Q0&list=PLsM3ZE5tGAVatO65JIxgskQh-OKoqM4F2&index=145