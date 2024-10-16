# Tiltfile

# Frontend
docker_build(
    'frontend',
    './frontend',
    live_update=[
        sync('./frontend/src', '/app/src'),
        run('npm install', trigger='./frontend/package.json'),
    ]
)

# Backend
docker_build(
    'backend',
    './backend',
    live_update=[
        sync('./backend/src', '/app/src'),
        run('mvn compile', trigger='./backend/pom.xml'),
    ]
)

# Kubernetes resources
k8s_yaml([
    'k8s/frontend.yaml',
    'k8s/backend.yaml',
    'k8s/postgres.yaml',
    'k8s/postgres-pvc.yaml',
    'k8s/postgres-secret.yaml'
])

# Port forwards
k8s_resource('frontend', port_forwards='3000')
k8s_resource('backend', port_forwards='8080')
k8s_resource('postgres', port_forwards='5432')

# Resource dependencies
k8s_resource('backend', resource_deps=['postgres'])
k8s_resource('frontend', resource_deps=['backend'])
