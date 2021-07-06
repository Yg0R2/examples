{{- define "examples.core.metadata.tpl" -}}
name: {{ .Release.Name }}
labels:
  {{- include "examples.core.labels.tpl" . | nindent 2 }}
{{- end -}}
