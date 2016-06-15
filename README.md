# signer
A small app to demo the fusion API, as provided via the Guardtime Fusion service broker.

##Prerequisites
Install and configure the Guardtime Service Broker tile to point to your active fusion installations.
Create a service instance named "fusion" via the service broker:
```bash
cf create-service guardtime fusion fusion
```

##Building and deploying:
``` bash
git clone git@github.com:cf-platform-eng/signer.git
cd signer
mvn clean install
```

##Using the demo
The demo consists of some rest endpoints that can be run directly from a browser:

to find the url of the demo app:
```bash
cf a

Getting apps in org yourorg / space yourspace as admin...
OK

name                requested state   instances   memory   disk   urls
signer              started           1/1         1G       1G     signer.yourdomain
```

###create a signature:
append a string to the "sign" endpoint:

http://url/sign/Wednesday

```json
{
"signatureUUID": "15D55786421A195ADA47D63F4E0354768B82227AA64B2A9562F983A37A2D62E7",
"entry": "Wednesday",
"encodedHash": "wKbMgpzQhzUpR2XHWTin2isPIi1S6Yv/E8sjfNmd6qw="
}
```

###see a signature's provenance
append a signatureUUID to the provenance endpoint:

http://url/provenance/15D55786421A195ADA47D63F4E0354768B82227AA64B2A9562F983A37A2D62E7

```json
[
{
"signatureName": null,
"signatureUUID": "15D55786421A195ADA47D63F4E0354768B82227AA64B2A9562F983A37A2D62E7",
"signatureB64Encoded": "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",
"identity": "FusionPOC.qafusionksigw-la3-01.GT.GT",
"aggregationTime": 1466000750000,
"publicationTime": 1466000750000,
"hashAlgorithm": "SHA2_256",
"hashB64Encoded": "8cjO1k4e3xreHY11HcWf5ZJUMw+Vqt8rM77X539OeTI=",
"signer": "a4a35a83-0fc5-42a6-851e-c70da35baf6a",
"digitalAssetSource": null,
"metadata": "{\"signatureUUID\":\"15D55786421A195ADA47D63F4E0354768B82227AA64B2A9562F983A37A2D62E7\",\"digitalAssetHash\":\"SHA-256:[C0A6CC829CD08735294765C75938A7DA2B0F222D52E98BFF13CB237CD99DEAAC]\"}",
"parentSignaturesUUID": []
}
]
```

###look up a signature
append a signatureUUID to the signature endpoint:

http://url/signature/15D55786421A195ADA47D63F4E0354768B82227AA64B2A9562F983A37A2D62E7

```json
{
"signatureName": null,
"signatureUUID": "15D55786421A195ADA47D63F4E0354768B82227AA64B2A9562F983A37A2D62E7",
"signatureB64Encoded": "iAAHUYgBAG0CBFdhZW4DAQsDAdMDAQUDAQUDAQMFIQHxyM7WTh7fGt4djXUd .... ",
"identity": "FusionPOC.qafusionksigw-la3-01.GT.GT",
"aggregationTime": 2147483647,
"publicationTime": 2147483647,
"hashAlgorithm": "SHA2_256",
"hashB64Encoded": "8cjO1k4e3xreHY11HcWf5ZJUMw+Vqt8rM77X539OeTI=",
"signer": "a4a35a83-0fc5-42a6-851e-c70da35baf6a",
"digitalAssetSource": null,
"metadata": "{\"signatureUUID\":\"15D55786421A195ADA47D63F4E0354768B82227AA64 ... "
}
```

###verify a signature
verification requires a POST to the verification endpoint:

http://url/verification

with a payload such as the following:

```json
{
  "base64EncodedDataHash": "LNtxNTm48TCcIWUa9Eef9r6jkKZQe9dFVfXIxNRfAlc\u003d",
  "signatureUUID": "E660AC607D7315CA8977AE530D8D3E8A47B2636A20C839FB101D9ADC0B0953A1"
}
```

the response will look like this:

```json
{
  "verified":false,
  "verificationFailureReasonCode":"GEN-1",
  "verificationTime":1466003659353,
  "metadataHashInvalid":true,
  "digitalAssetHashInvalid":true
}
```