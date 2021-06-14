{{- define "tentacle.metadata" -}}
{{- $appFullName := include "tentacle.appFullname" . -}}
metadata:
  name: {{ $appFullName }}
  namespace: {{ .Release.Namespace }}
  labels:
    app: {{ $appFullName }}
    helm.sh/chart: {{ printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end -}}
