def buildApp(){
    echo "Building"
}

def testApp(){
    echo "testing"
}

def deployApp(){
    echo "deploying"
    echo "version ${params.VERSION}"
}

return this