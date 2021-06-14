{{/*
Create `appSuffix` value, taking into account `global` dict
*/}}
{{- define "tentacle.appSuffix" -}}
    {{- if .Values.appSuffix -}}
        {{-  .Values.appSuffix -}}
    {{- else if and .Values.global .Values.global.appSuffix -}}
        {{- .Values.global.appSuffix -}}
    {{- end -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
Name includes service name & appSuffix.
It is no based on the release name due to existing usages of the same deployment names across different kubernetes namespaces.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "tentacle.appFullname" -}}
    {{- $appSuffix := include "tentacle.appSuffix" . -}}
    {{- printf "%s-%s" .Chart.Name $appSuffix| trunc 63 | trimSuffix "-" -}}
{{- end -}}
