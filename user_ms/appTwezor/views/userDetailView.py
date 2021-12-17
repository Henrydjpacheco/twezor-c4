from rest_framework import generics
from appTwezor.models.user import User
from appTwezor.serializers.userSerializer import UserSerializer

class UserDetailView(generics.RetrieveAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer