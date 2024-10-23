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
    'k8s/postgres-pvc.yaml',
    'k8s/postgres-secret.yaml'
])

# Wait for PVCs and secrets
local_resource(
    'wait-for-pvcs',
    'kubectl wait --for=condition=bound pvc/postgres-pvc pvc/nexus-data-pvc --timeout=60s',
    resource_deps=['postgres-pvc', 'nexus-data-pvc']
)

k8s_yaml('k8s/nexus.yaml')
k8s_yaml([
    'k8s/frontend.yaml',
    'k8s/backend.yaml',
    'k8s/postgres.yaml'
])

# Port forwards
k8s_resource('frontend', port_forwards='3000')
k8s_resource('backend', port_forwards='8080')
k8s_resource('postgres', port_forwards='5432')
k8s_resource('nexus', port_forwards='8081')

# Resource dependencies
k8s_resource('backend', resource_deps=['postgres', 'nexus'])
k8s_resource('frontend', resource_deps=['backend'])
