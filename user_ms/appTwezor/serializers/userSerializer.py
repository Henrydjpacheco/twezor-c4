from  rest_framework import serializers
from  appTwezor.models.user import User

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username', 'password', 'name', 'email', 'account']
