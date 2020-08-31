This Git repository is a collection of different examples.

Spring Security
===============

Projects
--------

- auth: Authentication Service
- backend: Dummy backend service
- layout: Layout Service with landing page
- nginx: Nginx config and certificates
- user: User Service

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
