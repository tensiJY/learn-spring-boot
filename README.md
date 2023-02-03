# learn-spring-boot

# branch

1. init

```
https://github.com/tensiJY/learn-spring-boot/tree/01_init
```

2. devtools

```
https://github.com/tensiJY/learn-spring-boot/tree/02_devtools
```

3. profile & config

```
https://github.com/tensiJY/learn-spring-boot/tree/03_profile
```

<details>
<summary> 설정 </summary>

- pom.xml

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
```

- component

```
@Component
@ConfigurationProperties(prefix="currency-service")
public class CurrencyServiceConfiguration {

	private String url;
	private String username;
	private String key;



	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
```

- properties

```
# config properties
currency-service.url=http://default1.in28minutes.com
currency-service.username=defaultusername
currency-service.key=defaultkey
```

</details>

<details>
<summary> 빌드 </summary>

```
clean install
```

</details>

4. Spring boot actuator

```
https://github.com/tensiJY/learn-spring-boot/tree/04_actuator
```

<details>

<summary>
	설정
</summary>

- pom.xml

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

- applications.properties

```
# actuator
## http://localhost:8080/actuator
#management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.include=health,metrics
```

- url
  > http//localhost:8080/actuator

</details>
