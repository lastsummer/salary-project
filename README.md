# salary-project

## 專案架構
 - [config](https://github.com/lastsummer/salary-project/tree/main/src/main/java/com/e104/salary/config)：設定檔
 - [exception](https://github.com/lastsummer/salary-project/tree/main/src/main/java/com/e104/salary/config)：例外處理，也處理了status code
 - [router](https://github.com/lastsummer/salary-project/tree/main/src/main/java/com/e104/salary/router)：request path
 - [model](https://github.com/lastsummer/salary-project/tree/main/src/main/java/com/e104/salary/router/model)：response model
 - [Service Interface](https://github.com/lastsummer/salary-project/tree/main/src/main/java/com/e104/salary/service)：Service interface
 - [Service Implement](https://github.com/lastsummer/salary-project/tree/main/src/main/java/com/e104/salary/service/impl):Service 實作


## Framework
- SpringBoot
- Spring JPA

## Dependency
- spring-boot-starter-validation
- spring-boot-devtools
- spring-boot-starter-web
- springfox-boot-starter

### http method
- get : 取得資料
- post : 新增資料
- put : 更新資料
- delete : 刪除資料

### url目前分三種格式
- ../api/version/...: 回傳為json 格式。並且帶有版號。
- ../auth/...: 登入時所使用的網址。
- ../dc/version/...: 內網才可以呼叫的api，並且帶有版號。
- port 為6565

### 回傳代碼status
- 200 查詢成功
- 201 新增成功
- 204 刪除/修改資源成功
- 400 參數錯誤
- 401 AC 未登入
- 403 AC 登入，產品沒登入
- 404 查詢結果失敗或是資料不存在
- 500 第三方api 發生錯誤
- ... 後續補充


### swagger
- version 3.0 oapi
- 設定檔 SwaggerConfig.java
- 網址：http://localhost:6565/swagger-ui/

### 功能
- @JsonFilter

### 環境變數
待補充

### CI/CD
待補充

### Log
待補充

