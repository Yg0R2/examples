@echo off
setlocal
if [%1]==[] (
  echo Usage: %0 ^<domain_name^> [additional_domain] [additional_domain] ...
  exit /b 1
)

set friendly=%1
if [%2]==[] (set addsan=) else (set addsan=1)

rem ***** If domain is wildcard substitute asterisk character with a _wildcard text for the file name
set fn=%~1
if [%fn:~0,2%] == [*.] set fn=_wildcard.%fn:~2%

rem ***** Write openssl configuration file
echo [req]>%fn%.conf
echo default_bits = 2048>>%fn%.conf
echo prompt = no>>%fn%.conf
echo default_md = sha256>>%fn%.conf
echo distinguished_name = req_distinguished_name>>%fn%.conf
if [%addsan%] == [1] echo x509_extensions = v3_req>>%fn%.conf
echo.>>%fn%.conf
echo [req_distinguished_name]>>%fn%.conf
echo CN = %~1>>%fn%.conf
echo.>>%fn%.conf

if not [%addsan%] == [1] goto :makecert

rem ***** Write san related sections
echo [v3_req]>>%fn%.conf
echo subjectAltName = @san>>%fn%.conf
echo.>>%fn%.conf
echo [san]>>%fn%.conf
set /a sanid = 0

rem ***** Loop through SAN names
:sanloop
set /a sanid+=1
echo DNS.%sanid% = %~1>>%fn%.conf
shift
if [%~1]==[] goto :makecert
goto :sanloop

:makecert
openssl req -new -x509 -nodes -days 3650 -sha256 -newkey rsa:4096 -keyout %fn%.key -out %fn%.crt -config %fn%.conf
openssl pkcs12 -export -out %fn%.pfx -inkey %fn%.key -in %fn%.crt -name %friendly% -passout pass:
