{{/* */}}
{{- define "dummy.app" -}}
app_name: {{ .Chart.Name }}
app_version: {{ .Chart.Version | quote }}
{{- end -}}

{{/* Generate labels */}}
{{- define "dummy.labels" -}}
  labels:
{{- /*    {{ template "dummy.app" . }}*/}}
{{ include "dummy.app" . | indent 4 }}
    chart: {{ .Chart.Name }}
    date: {{ now | htmlDate }}
    generator: helm
    version: {{ .Chart.Version }}
{{- end -}}
