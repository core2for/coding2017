package com.coderising.jvm.loader;


import com.coderising.jvm.clz.AccessFlag;
import com.coderising.jvm.clz.ClassFile;
import com.coderising.jvm.clz.ClassIndex;
import com.coderising.jvm.constant.ClassInfo;
import com.coderising.jvm.constant.ConstantPool;
import com.coderising.jvm.constant.FieldRefInfo;
import com.coderising.jvm.constant.MethodRefInfo;
import com.coderising.jvm.constant.NameAndTypeInfo;
import com.coderising.jvm.constant.NullConstantInfo;
import com.coderising.jvm.constant.StringInfo;
import com.coderising.jvm.constant.UTF8Info;

public class ClassFileParser {

	public ClassFile parse(byte[] codes) {
		ClassFile clzFile = new ClassFile();
		ByteCodeIterator iter = new ByteCodeIterator(codes);
		String magicNumber = iter.nextU4ToHexString();
		if (!magicNumber.equals("cafebabe")) {
			return null;
		}
		clzFile.setMinorVersion(iter.nextU2ToInt());
		clzFile.setMajorVersion(iter.nextU2ToInt());
		ConstantPool pool = parseConstantPool(iter);
		clzFile.setConstPool(pool);

		AccessFlag flag = parseAccessFlag(iter);
		clzFile.setAccessFlag(flag);

		ClassIndex clzIndex = parseClassIndex(iter);
		clzFile.setClassIndex(clzIndex);

		return clzFile;
	}

	private AccessFlag parseAccessFlag(ByteCodeIterator iter) {
		int accessFlag = iter.nextU2ToInt();
		AccessFlag access = new AccessFlag(accessFlag);
		return access;
	}

	private ClassIndex parseClassIndex(ByteCodeIterator iter) {
		int thisClassIndex = iter.nextU2ToInt();
		int superClassIndex = iter.nextU2ToInt();
		//int interfacesIndex = iter.nextU2ToInt();
		ClassIndex  clzIndex = new ClassIndex();
		clzIndex.setSuperClassIndex(superClassIndex);
		clzIndex.setThisClassIndex(thisClassIndex);
		return clzIndex;

	}

	private ConstantPool parseConstantPool(ByteCodeIterator iter) {
		int poolCount = iter.nextU2ToInt();
		ConstantPool pool = new ConstantPool();
		pool.addConstantInfo(new NullConstantInfo());
		for (int i = 1; i < poolCount; i++) {
			int tag = iter.nextU1ToInt();
			if (tag == 7) {
				// Class info
				int utf8Index = iter.nextU2ToInt();
				ClassInfo clzInfo = new ClassInfo(pool);
				clzInfo.setUtf8Index(utf8Index);
				pool.addConstantInfo(clzInfo);
			} else if (tag == 1) {
				int length = iter.nextU2ToInt();
				byte[] data = iter.getBytes(length);
				UTF8Info utf8Info = new UTF8Info(pool);
				utf8Info.setLength(length);
				utf8Info.setValue(new String(data));
				pool.addConstantInfo(utf8Info);
			} else if (tag == 8) {
				// String info
				int index = iter.nextU2ToInt();
				StringInfo strInfo = new StringInfo(pool);
				strInfo.setIndex(index);
				pool.addConstantInfo(strInfo);

			} else if (tag == 9) {
				//
				int classInfoIndex = iter.nextU2ToInt();
				int nameAndTypeIndex = iter.nextU2ToInt();
				FieldRefInfo fieldInfo = new FieldRefInfo(pool);
				fieldInfo.setClassInfoIndex(classInfoIndex);
				fieldInfo.setNameAndTypeIndex(nameAndTypeIndex);
				pool.addConstantInfo(fieldInfo);
			} else if (tag == 10) {
				// Method Info
				int classInfoIndex = iter.nextU2ToInt();
				int nameAndTypeIndex = iter.nextU2ToInt();
				MethodRefInfo methodInfo = new MethodRefInfo(pool);
				methodInfo.setClassInfoIndex(classInfoIndex);
				methodInfo.setNameAndTypeIndex(nameAndTypeIndex);
				pool.addConstantInfo(methodInfo);
			} else if (tag == 12) {
				int index1 = iter.nextU2ToInt();
				int index2 = iter.nextU2ToInt();
				NameAndTypeInfo nameInfo = new NameAndTypeInfo(pool);
				nameInfo.setIndex1(index1);
				nameInfo.setIndex2(index2);
				pool.addConstantInfo(nameInfo);
			} else {
				throw new RuntimeException("the constant pool tag " + tag + " has not been implemented");
			}

		}
		return pool;
	}
	
	private void parseInterfaces(ByteCodeIterator iter) {
		int interfaceCount = iter.nextU2ToInt();

		System.out.println("interfaceCount:" + interfaceCount);

		// TODO : 如果实现了interface, 这里需要解析
	}

}