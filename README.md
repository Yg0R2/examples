This Git repository is a collection of different examples.

Spring Security
===============

Projects
--------

- auth: Authentication Service
- backend: Dummy backend service
- gradle-plugin: Plugin for Gradle
- jenkins-pipeline: Centralized Jenkins pipeline implementation
- layout: Layout Service with landing page
- nginx: Nginx config and certificates
- ui: UI module for React testing
- ui-core: UI module for library testing
- user: User Service

### Standalone projects

- code-kata: Sample projects for practice
- maven-test: Test maven project with Docker and Jenkins pipeline integration

Nginx
-----

Keystore:
```
keytool -genkeypair -alias yg0r2-examples -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore examples-ssl-key.p12 -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -validity 3650 -storepass yg0r2-examples -keypass yg0r2-examples
```

Cert:
```
openssl pkcs12 -info -in examples-ssl-key.p12 -out examples-ssl.crt  -nodes -nokeys
```

Key:
```
openssl pkcs12 -info -in examples-ssl-key.p12 -out examples-ssl.key  -nodes -nocerts
```

Docker integration
------------------
- Build all projects with `./gradlew bootBuildImage`
- Start everything with `docker-compose up`
- Open https://localhost

Jenkins Pipeline
----------------

- Configure the Global `user.name` and `user.email` for Jenkins
- Create an SSH key for this user/email and place it under (On Windows) `c:\Windows\System32\config\systemprofile\.ssh\` directory
- Add a certificate to Jenkins global credentials for this user
- Configure the job with:
  - SSH URL and to use the credential
  - Clean workspace before checkout
  - `Custom user name/e-mail address` (required to be able to use `git push` directly from the pipeline)
