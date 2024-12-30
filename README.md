# OpenWeatherMapAutomationExample

#### Required Software
Java 23+<br>
Gradle 8.10.1+<br>
<hr>

#### How to execute the API tests:
```gradle clean project-api:test -Denvironment=dev```

<hr>

#### How to execute the UI tests:
```gradle clean project-ui:test -Denvironment=local -Dbrowser=firefox.local```
<br>
```gradle clean project-ui:test -Denvironment=local -Dbrowser=chrome.local```

<hr>

#### Reporting 

Test Reports: `build/reports/tests/test/index.html`
<br>
Logging: `build/logs` (log file per test class)

<hr>

#### Additional Test Cases For WeatherAPI<br>
1. Verify `name` in the Json response match one of the given locations cities
2. Verify `null` value in the appId parameter
3. Verify invalid US location (this may one or more of the following: invalid city, invalid state or invalid country)
4. Verify valid international location
5. Verify `null` value for location
6. Verify when `units` is not provided within the request
7. Verify when `units` is not a valid option
8. Verify when `units` is `null`
9. Verify when `units` is set to `standard`
10. Verify when `units` is set to `metric`
11. Verify when `units` is set to `imperial`
12. Verify when `mode` is not provided within the request
13. Verify when `mode` is not a valid option 
14. Verify when `mode` is `null`
15. Verify when `mode` is set to `xml`
16. Verify when `mode` is set to `html`
17. Verify when `lang` is not provided within the request 
18. Verify when `lang` is not a valid option 
19. Verify when `lang` is `null`
20. verify a small set of random languages
21. Verify correct headers and/or cookies
<hr>

#### Additional Future Testing<br>
Performance, Stress and Load (PSL) testing via Gatling (normally kept in a separate repo)<br>
Accessibility testing <br>
Visual based testing <br>
Security testing