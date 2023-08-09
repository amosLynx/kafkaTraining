// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: userMessage.proto
package com.ex.pbtojson;

public final class UserMessage {
  private UserMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface usersOrBuilder extends
      // @@protoc_insertion_point(interface_extends:users)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 registertime = 1;</code>
     * @return The registertime.
     */
    long getRegistertime();

    /**
     * <code>string userid = 2;</code>
     * @return The userid.
     */
    java.lang.String getUserid();
    /**
     * <code>string userid = 2;</code>
     * @return The bytes for userid.
     */
    com.google.protobuf.ByteString
        getUseridBytes();

    /**
     * <code>string regionid = 3;</code>
     * @return The regionid.
     */
    java.lang.String getRegionid();
    /**
     * <code>string regionid = 3;</code>
     * @return The bytes for regionid.
     */
    com.google.protobuf.ByteString
        getRegionidBytes();

    /**
     * <code>string gender = 4;</code>
     * @return The gender.
     */
    java.lang.String getGender();
    /**
     * <code>string gender = 4;</code>
     * @return The bytes for gender.
     */
    com.google.protobuf.ByteString
        getGenderBytes();
  }
  /**
   * Protobuf type {@code users}
   */
  public static final class users extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:users)
      usersOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use users.newBuilder() to construct.
    private users(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private users() {
      userid_ = "";
      regionid_ = "";
      gender_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new users();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private users(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              registertime_ = input.readInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              userid_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              regionid_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              gender_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return UserMessage.internal_static_users_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return UserMessage.internal_static_users_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              UserMessage.users.class, UserMessage.users.Builder.class);
    }

    public static final int REGISTERTIME_FIELD_NUMBER = 1;
    private long registertime_;
    /**
     * <code>int64 registertime = 1;</code>
     * @return The registertime.
     */
    @java.lang.Override
    public long getRegistertime() {
      return registertime_;
    }

    public static final int USERID_FIELD_NUMBER = 2;
    private volatile java.lang.Object userid_;
    /**
     * <code>string userid = 2;</code>
     * @return The userid.
     */
    @java.lang.Override
    public java.lang.String getUserid() {
      java.lang.Object ref = userid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userid_ = s;
        return s;
      }
    }
    /**
     * <code>string userid = 2;</code>
     * @return The bytes for userid.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getUseridBytes() {
      java.lang.Object ref = userid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REGIONID_FIELD_NUMBER = 3;
    private volatile java.lang.Object regionid_;
    /**
     * <code>string regionid = 3;</code>
     * @return The regionid.
     */
    @java.lang.Override
    public java.lang.String getRegionid() {
      java.lang.Object ref = regionid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        regionid_ = s;
        return s;
      }
    }
    /**
     * <code>string regionid = 3;</code>
     * @return The bytes for regionid.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getRegionidBytes() {
      java.lang.Object ref = regionid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        regionid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GENDER_FIELD_NUMBER = 4;
    private volatile java.lang.Object gender_;
    /**
     * <code>string gender = 4;</code>
     * @return The gender.
     */
    @java.lang.Override
    public java.lang.String getGender() {
      java.lang.Object ref = gender_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gender_ = s;
        return s;
      }
    }
    /**
     * <code>string gender = 4;</code>
     * @return The bytes for gender.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getGenderBytes() {
      java.lang.Object ref = gender_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gender_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (registertime_ != 0L) {
        output.writeInt64(1, registertime_);
      }
      if (!getUseridBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, userid_);
      }
      if (!getRegionidBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, regionid_);
      }
      if (!getGenderBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, gender_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (registertime_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, registertime_);
      }
      if (!getUseridBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, userid_);
      }
      if (!getRegionidBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, regionid_);
      }
      if (!getGenderBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, gender_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof UserMessage.users)) {
        return super.equals(obj);
      }
      UserMessage.users other = (UserMessage.users) obj;

      if (getRegistertime()
          != other.getRegistertime()) return false;
      if (!getUserid()
          .equals(other.getUserid())) return false;
      if (!getRegionid()
          .equals(other.getRegionid())) return false;
      if (!getGender()
          .equals(other.getGender())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + REGISTERTIME_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRegistertime());
      hash = (37 * hash) + USERID_FIELD_NUMBER;
      hash = (53 * hash) + getUserid().hashCode();
      hash = (37 * hash) + REGIONID_FIELD_NUMBER;
      hash = (53 * hash) + getRegionid().hashCode();
      hash = (37 * hash) + GENDER_FIELD_NUMBER;
      hash = (53 * hash) + getGender().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static UserMessage.users parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static UserMessage.users parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static UserMessage.users parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static UserMessage.users parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static UserMessage.users parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static UserMessage.users parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static UserMessage.users parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static UserMessage.users parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static UserMessage.users parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static UserMessage.users parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static UserMessage.users parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static UserMessage.users parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(UserMessage.users prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code users}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:users)
        UserMessage.usersOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return UserMessage.internal_static_users_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return UserMessage.internal_static_users_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                UserMessage.users.class, UserMessage.users.Builder.class);
      }

      // Construct using UserMessage.users.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        registertime_ = 0L;

        userid_ = "";

        regionid_ = "";

        gender_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return UserMessage.internal_static_users_descriptor;
      }

      @java.lang.Override
      public UserMessage.users getDefaultInstanceForType() {
        return UserMessage.users.getDefaultInstance();
      }

      @java.lang.Override
      public UserMessage.users build() {
        UserMessage.users result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public UserMessage.users buildPartial() {
        UserMessage.users result = new UserMessage.users(this);
        result.registertime_ = registertime_;
        result.userid_ = userid_;
        result.regionid_ = regionid_;
        result.gender_ = gender_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof UserMessage.users) {
          return mergeFrom((UserMessage.users)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(UserMessage.users other) {
        if (other == UserMessage.users.getDefaultInstance()) return this;
        if (other.getRegistertime() != 0L) {
          setRegistertime(other.getRegistertime());
        }
        if (!other.getUserid().isEmpty()) {
          userid_ = other.userid_;
          onChanged();
        }
        if (!other.getRegionid().isEmpty()) {
          regionid_ = other.regionid_;
          onChanged();
        }
        if (!other.getGender().isEmpty()) {
          gender_ = other.gender_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        UserMessage.users parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (UserMessage.users) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long registertime_ ;
      /**
       * <code>int64 registertime = 1;</code>
       * @return The registertime.
       */
      @java.lang.Override
      public long getRegistertime() {
        return registertime_;
      }
      /**
       * <code>int64 registertime = 1;</code>
       * @param value The registertime to set.
       * @return This builder for chaining.
       */
      public Builder setRegistertime(long value) {
        
        registertime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 registertime = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearRegistertime() {
        
        registertime_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object userid_ = "";
      /**
       * <code>string userid = 2;</code>
       * @return The userid.
       */
      public java.lang.String getUserid() {
        java.lang.Object ref = userid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          userid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string userid = 2;</code>
       * @return The bytes for userid.
       */
      public com.google.protobuf.ByteString
          getUseridBytes() {
        java.lang.Object ref = userid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          userid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string userid = 2;</code>
       * @param value The userid to set.
       * @return This builder for chaining.
       */
      public Builder setUserid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        userid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string userid = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearUserid() {
        
        userid_ = getDefaultInstance().getUserid();
        onChanged();
        return this;
      }
      /**
       * <code>string userid = 2;</code>
       * @param value The bytes for userid to set.
       * @return This builder for chaining.
       */
      public Builder setUseridBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        userid_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object regionid_ = "";
      /**
       * <code>string regionid = 3;</code>
       * @return The regionid.
       */
      public java.lang.String getRegionid() {
        java.lang.Object ref = regionid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          regionid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string regionid = 3;</code>
       * @return The bytes for regionid.
       */
      public com.google.protobuf.ByteString
          getRegionidBytes() {
        java.lang.Object ref = regionid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          regionid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string regionid = 3;</code>
       * @param value The regionid to set.
       * @return This builder for chaining.
       */
      public Builder setRegionid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        regionid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string regionid = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearRegionid() {
        
        regionid_ = getDefaultInstance().getRegionid();
        onChanged();
        return this;
      }
      /**
       * <code>string regionid = 3;</code>
       * @param value The bytes for regionid to set.
       * @return This builder for chaining.
       */
      public Builder setRegionidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        regionid_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object gender_ = "";
      /**
       * <code>string gender = 4;</code>
       * @return The gender.
       */
      public java.lang.String getGender() {
        java.lang.Object ref = gender_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gender_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string gender = 4;</code>
       * @return The bytes for gender.
       */
      public com.google.protobuf.ByteString
          getGenderBytes() {
        java.lang.Object ref = gender_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gender_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string gender = 4;</code>
       * @param value The gender to set.
       * @return This builder for chaining.
       */
      public Builder setGender(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        gender_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string gender = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearGender() {
        
        gender_ = getDefaultInstance().getGender();
        onChanged();
        return this;
      }
      /**
       * <code>string gender = 4;</code>
       * @param value The bytes for gender to set.
       * @return This builder for chaining.
       */
      public Builder setGenderBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        gender_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:users)
    }

    // @@protoc_insertion_point(class_scope:users)
    private static final UserMessage.users DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new UserMessage.users();
    }

    public static UserMessage.users getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<users>
        PARSER = new com.google.protobuf.AbstractParser<users>() {
      @java.lang.Override
      public users parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new users(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<users> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<users> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public UserMessage.users getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_users_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_users_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021userMessage.proto\"O\n\005users\022\024\n\014register" +
      "time\030\001 \001(\003\022\016\n\006userid\030\002 \001(\t\022\020\n\010regionid\030\003" +
      " \001(\t\022\016\n\006gender\030\004 \001(\tb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_users_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_users_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_users_descriptor,
        new java.lang.String[] { "Registertime", "Userid", "Regionid", "Gender", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}