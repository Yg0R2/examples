{{/*
Create a default fully qualified app name.
Name includes service name & appSuffix.
It is no based on the release name due to existing usages of the same deployment names across different kubernetes namespaces.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
*/}}
{{- define "tentacle.helpers.appFullname" -}}
  {{- $appSuffix := include "tentacle.helpers.appSuffix" . -}}
  {{- printf "%s-%s" .Chart.Name $appSuffix| trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create `appSuffix` value, taking into account `global` dict
*/}}
{{- define "tentacle.helpers.appSuffix" -}}
  {{- if .Values.appSuffix -}}
    {{-  .Values.appSuffix -}}
  {{- else if and .Values.global .Values.global.appSuffix -}}
    {{- .Values.global.appSuffix -}}
  {{- end -}}
{{- end -}}

{{- /*
tentacle.helpers.merge will merge two YAML templates and output the result.
This takes an array of three values:
- the top context
- the template name of the overrides (destination)
- the template name of the base (source)
*/}}
{{- define "tentacle.helpers.merge" -}}
  {{- $top := first . -}}
  {{- $overrides := (dict ) -}}

  {{- range (rest .) -}}
    {{- $tpl := fromYaml (include . $top) | default (dict ) -}}
    {{- $overrides = (merge $overrides $tpl) -}}
  {{- end -}}

  {{- toYaml $overrides -}}
{{- end -}}
