*说明:*  文件`template.yml`用于fun build后fun local invoke的本地调试; fun build后执行fun package上传OSS时生成文件`template.packaged.yml`


`函数多环境部署`

    cd /home/chen/IdeaProjects/github/lab-multi-func/func-distribute
    fun build
    fun package --oss-bucket oss上的bucket名称
  将文件`func-distribute/template.packaged.yml`内上传OSS后的新版本CodeUri更新到部署文件`./deployments/`
    
     make fun-deploy RUN_ENV=uat
     
`本地调试`
    
    cd /home/chen/IdeaProjects/github/lab-multi-func/func-distribute
    fun build    
    fun local invoke -d 3001  -e ./param.json lab-distribute-func     
    