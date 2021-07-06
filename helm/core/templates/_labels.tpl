{{- define "examples.core.labels.tpl" -}}
app: {{ .Release.Name }}
version: {{ .Values.appVersion }}
{{- end -}}
